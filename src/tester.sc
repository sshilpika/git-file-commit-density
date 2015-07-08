import spray.json._
import DefaultJsonProtocol._
import concurrent.ExecutionContext.Implicits._
import scala.concurrent.Future
val str = "[\n  {\n    \"sha\": \"8618701938133258cbaf59e6dd223f7ac8865bb2\",\n    \"commit\": {\n      \"author\": {\n        \"name\": \"FNU Shilpika\",\n        \"email\": \"sshilpika5@gmail.com\",\n        \"date\": \"2015-03-17T03:37:35Z\"\n      },\n      \"committer\": {\n        \"name\": \"FNU Shilpika\",\n        \"email\": \"sshilpika5@gmail.com\",\n        \"date\": \"2015-03-17T03:37:35Z\"\n      },\n      \"message\": \"better imlpementation of spray with actors\",\n      \"tree\": {\n        \"sha\": \"fecf24c1c7b1afb8045aef6a86beae3d10f995dd\",\n        \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/git/trees/fecf24c1c7b1afb8045aef6a86beae3d10f995dd\"\n      },\n      \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/git/commits/8618701938133258cbaf59e6dd223f7ac8865bb2\",\n      \"comment_count\": 0\n    },\n    \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/commits/8618701938133258cbaf59e6dd223f7ac8865bb2\",\n    \"html_url\": \"https://github.com/sshilpika/metrics-test/commit/8618701938133258cbaf59e6dd223f7ac8865bb2\",\n    \"comments_url\": \"https://api.github.com/repos/sshilpika/metrics-test/commits/8618701938133258cbaf59e6dd223f7ac8865bb2/comments\",\n    \"author\": {\n      \"login\": \"sshilpika\",\n      \"id\": 9967469,\n      \"avatar_url\": \"https://avatars.githubusercontent.com/u/9967469?v=3\",\n      \"gravatar_id\": \"\",\n      \"url\": \"https://api.github.com/users/sshilpika\",\n      \"html_url\": \"https://github.com/sshilpika\",\n      \"followers_url\": \"https://api.github.com/users/sshilpika/followers\",\n      \"following_url\": \"https://api.github.com/users/sshilpika/following{/other_user}\",\n      \"gists_url\": \"https://api.github.com/users/sshilpika/gists{/gist_id}\",\n      \"starred_url\": \"https://api.github.com/users/sshilpika/starred{/owner}{/repo}\",\n      \"subscriptions_url\": \"https://api.github.com/users/sshilpika/subscriptions\",\n      \"organizations_url\": \"https://api.github.com/users/sshilpika/orgs\",\n      \"repos_url\": \"https://api.github.com/users/sshilpika/repos\",\n      \"events_url\": \"https://api.github.com/users/sshilpika/events{/privacy}\",\n      \"received_events_url\": \"https://api.github.com/users/sshilpika/received_events\",\n      \"type\": \"User\",\n      \"site_admin\": false\n    },\n    \"committer\": {\n      \"login\": \"sshilpika\",\n      \"id\": 9967469,\n      \"avatar_url\": \"https://avatars.githubusercontent.com/u/9967469?v=3\",\n      \"gravatar_id\": \"\",\n      \"url\": \"https://api.github.com/users/sshilpika\",\n      \"html_url\": \"https://github.com/sshilpika\",\n      \"followers_url\": \"https://api.github.com/users/sshilpika/followers\",\n      \"following_url\": \"https://api.github.com/users/sshilpika/following{/other_user}\",\n      \"gists_url\": \"https://api.github.com/users/sshilpika/gists{/gist_id}\",\n      \"starred_url\": \"https://api.github.com/users/sshilpika/starred{/owner}{/repo}\",\n      \"subscriptions_url\": \"https://api.github.com/users/sshilpika/subscriptions\",\n      \"organizations_url\": \"https://api.github.com/users/sshilpika/orgs\",\n      \"repos_url\": \"https://api.github.com/users/sshilpika/repos\",\n      \"events_url\": \"https://api.github.com/users/sshilpika/events{/privacy}\",\n      \"received_events_url\": \"https://api.github.com/users/sshilpika/received_events\",\n      \"type\": \"User\",\n      \"site_admin\": false\n    },\n    \"parents\": [\n      {\n        \"sha\": \"ace8944a4c10bc5c304e9b05c37459daa168dd18\",\n        \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/commits/ace8944a4c10bc5c304e9b05c37459daa168dd18\",\n        \"html_url\": \"https://github.com/sshilpika/metrics-test/commit/ace8944a4c10bc5c304e9b05c37459daa168dd18\"\n      }\n    ]\n  },\n  {\n    \"sha\": \"ace8944a4c10bc5c304e9b05c37459daa168dd18\",\n    \"commit\": {\n      \"author\": {\n        \"name\": \"FNU Shilpika\",\n        \"email\": \"sshilpika5@gmail.com\",\n        \"date\": \"2015-03-11T08:32:34Z\"\n      },\n      \"committer\": {\n        \"name\": \"FNU Shilpika\",\n        \"email\": \"sshilpika5@gmail.com\",\n        \"date\": \"2015-03-11T08:32:34Z\"\n      },\n      \"message\": \"functions onCompleteWithRepoErrorHandler and repoErrorHandler commented\",\n      \"tree\": {\n        \"sha\": \"e3612c665e03235249bc673b0db3d41cd55a4496\",\n        \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/git/trees/e3612c665e03235249bc673b0db3d41cd55a4496\"\n      },\n      \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/git/commits/ace8944a4c10bc5c304e9b05c37459daa168dd18\",\n      \"comment_count\": 0\n    },\n    \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/commits/ace8944a4c10bc5c304e9b05c37459daa168dd18\",\n    \"html_url\": \"https://github.com/sshilpika/metrics-test/commit/ace8944a4c10bc5c304e9b05c37459daa168dd18\",\n    \"comments_url\": \"https://api.github.com/repos/sshilpika/metrics-test/commits/ace8944a4c10bc5c304e9b05c37459daa168dd18/comments\",\n    \"author\": {\n      \"login\": \"sshilpika\",\n      \"id\": 9967469,\n      \"avatar_url\": \"https://avatars.githubusercontent.com/u/9967469?v=3\",\n      \"gravatar_id\": \"\",\n      \"url\": \"https://api.github.com/users/sshilpika\",\n      \"html_url\": \"https://github.com/sshilpika\",\n      \"followers_url\": \"https://api.github.com/users/sshilpika/followers\",\n      \"following_url\": \"https://api.github.com/users/sshilpika/following{/other_user}\",\n      \"gists_url\": \"https://api.github.com/users/sshilpika/gists{/gist_id}\",\n      \"starred_url\": \"https://api.github.com/users/sshilpika/starred{/owner}{/repo}\",\n      \"subscriptions_url\": \"https://api.github.com/users/sshilpika/subscriptions\",\n      \"organizations_url\": \"https://api.github.com/users/sshilpika/orgs\",\n      \"repos_url\": \"https://api.github.com/users/sshilpika/repos\",\n      \"events_url\": \"https://api.github.com/users/sshilpika/events{/privacy}\",\n      \"received_events_url\": \"https://api.github.com/users/sshilpika/received_events\",\n      \"type\": \"User\",\n      \"site_admin\": false\n    },\n    \"committer\": {\n      \"login\": \"sshilpika\",\n      \"id\": 9967469,\n      \"avatar_url\": \"https://avatars.githubusercontent.com/u/9967469?v=3\",\n      \"gravatar_id\": \"\",\n      \"url\": \"https://api.github.com/users/sshilpika\",\n      \"html_url\": \"https://github.com/sshilpika\",\n      \"followers_url\": \"https://api.github.com/users/sshilpika/followers\",\n      \"following_url\": \"https://api.github.com/users/sshilpika/following{/other_user}\",\n      \"gists_url\": \"https://api.github.com/users/sshilpika/gists{/gist_id}\",\n      \"starred_url\": \"https://api.github.com/users/sshilpika/starred{/owner}{/repo}\",\n      \"subscriptions_url\": \"https://api.github.com/users/sshilpika/subscriptions\",\n      \"organizations_url\": \"https://api.github.com/users/sshilpika/orgs\",\n      \"repos_url\": \"https://api.github.com/users/sshilpika/repos\",\n      \"events_url\": \"https://api.github.com/users/sshilpika/events{/privacy}\",\n      \"received_events_url\": \"https://api.github.com/users/sshilpika/received_events\",\n      \"type\": \"User\",\n      \"site_admin\": false\n    },\n    \"parents\": [\n      {\n        \"sha\": \"ff103006546eafa16fb7f9cba1dd7da61024e367\",\n        \"url\": \"https://api.github.com/repos/sshilpika/metrics-test/commits/ff103006546eafa16fb7f9cba1dd7da61024e367\",\n        \"html_url\": \"https://github.com/sshilpika/metrics-test/commit/ff103006546eafa16fb7f9cba1dd7da61024e367\"\n      }\n    ]\n  }"
/*
val m = str.parseJson.convertTo[List[JsValue]].foldLeft(Nil:List[Future[Map[String,JsValue]]]){(tuplesList,commits) => {
  tuplesList:+Future{commits.asJsObject.fields.filter{case(s,v) =>
    Set("sha").contains(s)
    //Set("date")
  }}
}}*/
val z = "[{ \"sha\": \"ca7abc19714b3012f64b59\", \"filename\": \"src/main/scala/GithubApiCall.scala\", \"status\": \"modified\", \"additions\": 7, \"deletions\": 1, \"changes\": 8},{ \"sha\": \"ca7abc19714b3012f64b5936fbf82b0633ec0212\", \"filename\": \"src/main/scala/GithubApiCall.scala\", \"status\": \"modified\", \"additions\": 7, \"deletions\": 1, \"changes\": 8}]"
z.parseJson.convertTo[List[JsValue]].filter{x =>
  x.asJsObject.getFields("sha").contains("\"ca7abc19714b3012f64b5936fbf82b0633ec0212\"".parseJson)}//.fields.filter{case(s,v)=> }
val o = z.parseJson.convertTo[List[JsValue]]
val p = o.contains("\"ca7abc19714b3012f64b5936fbf82b0633ec0212\"".parseJson)
z.parseJson.convertTo[List[JsValue]].map(x =>x.asJsObject.getFields("sha","filename"))
import java.util.Calendar
import java.text.SimpleDateFormat
import java.util.TimeZone
val s = "2015-03-17T03:37:35Z"
val s1 = "2015-03-11T08:32:34Z"
val sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
val t = sdf.parse(s)
val t1 = sdf.parse(s1)
//t1.toInstant.minus()
//sdf.parse((t.getTime - t1.getTime))
import java.time.Duration
import java.time.Instant
import java.time.temporal.Temporal
import java.time.temporal.ChronoUnit
val gap = ChronoUnit.MILLIS.between(t1.toInstant,t.toInstant);