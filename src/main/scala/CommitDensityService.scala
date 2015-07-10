package edu.luc.cs499.scala.gitcommitdensity.service

import akka.actor.Actor
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http
import spray.http.MediaTypes._
import spray.routing.HttpService
import spray.http._
import spray.httpx.RequestBuilding._
import spray.json._
import DefaultJsonProtocol._
import spray.routing._
import util._
import concurrent.duration._
import concurrent.ExecutionContext.Implicits._
import concurrent.Future


/**
 * Created by sshilpika on 6/30/15.
 */

trait CommitDensityService extends HttpService{

  def gitFileCommits(user: String, repo: String, filePath:String, since:String, until: String): Future[String] ={
    implicit val actorSys = Boot.system
    implicit val timeout = Timeout(60.seconds)

    val gitFileCommitList =
      (IO(Http) ? Get("https://api.github.com/repos/"+user+"/"+repo+"/commits?path="+filePath+"&since="+since+"&until="+until)).mapTo[HttpResponse]

    val shaList = gitFileCommitList.map(gitList =>
      gitList.entity.data.asString.parseJson.convertTo[List[JsValue]].foldLeft(Nil:List[JsValue]){(tuplesList,commits) =>
        tuplesList++commits.asJsObject.getFields("url")
      }
    )

    getCommitLOC(filePath,shaList,since,until)
  }

  import java.text.SimpleDateFormat
  import java.time.temporal.ChronoUnit
  import java.time.temporal.Temporal

  def getCommitLOC(filePath: String, urlList:Future[List[JsValue]],since:String, until:String): Future[String] ={
    implicit val actorSys = Boot.system
    implicit val timeout = Timeout(60.seconds)
    urlList.flatMap(lis =>{
    val sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
      Future.sequence(lis.map(url =>{
        val gitFileCommitList =
          (IO(Http) ? Get(url.compactPrint.replaceAll("\"",""))).mapTo[HttpResponse]

        val tupleList = gitFileCommitList.map(commit =>{

          val filesList = commit.entity.data.asString.parseJson.asJsObject.getFields("commit","files")

          val fileName = filesList(1).convertTo[List[JsValue]]filter { x1 =>
            x1.asJsObject.getFields("filename").contains(("\"" + filePath + "\"").parseJson)
          }

          val lisInts = fileName.foldLeft(0){(lis, v) => {
            val change = v.asJsObject.getFields("additions","deletions")
            change(0).convertTo[Int]- change(1).convertTo[Int]
          }
          }
          val date = filesList(0).asJsObject("HERE").getFields("committer")(0).asJsObject("HERE1").getFields("date")(0).compactPrint.replaceAll("\"","")

          val inst = sdf.parse(date).toInstant

          (inst,lisInts)
        })
        tupleList

      })).map(a => {

        val lis1 = a.sorted
        println(lis1+"LLLIIISSS")
        val lis2 = lis1.tail:+(sdf.parse(until).toInstant,a.last._2)
        println(lis2)
        val lis3 = lis1.zip(lis2)
        println(lis3+"lis3")

        val result = lis3.map(c => {

          (ChronoUnit.MILLIS.between(c._1._1,c._2._1),c._1._2)

        })
        val totalMillis = result.foldLeft(0L:Long){(l,z) => l+z._1}
          val finalResult = (result.map(z => z._1*z._2).sum)/totalMillis
          "(Date, LOC) = "+lis1.toString+"\nFinal Result = "+(finalResult.toDouble/1000)+" KLOC"
      }

        )})
  }


  val myRoute = path(Segment / Segment / RestPath) { (user, repo, filePath) =>
    get {
      respondWithMediaType(`text/plain`) { // XML is marshalled to `text/xml` by default, so we simply override here
        parameters('since, 'until){ (since,until) =>
          onComplete(gitFileCommits(user,repo,filePath.toString, since,until)){
            case Success(value) => complete(value)
            case Failure(value) => complete("Request to github failed with value : "+value)
          }
        }
      }
    }
  }
}
class MyServiceActor extends Actor with CommitDensityService {

  def actorRefFactory = context

  def receive = runRoute(myRoute)
}
