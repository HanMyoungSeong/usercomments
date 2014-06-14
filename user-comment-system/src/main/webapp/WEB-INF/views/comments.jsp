<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>댓글 시스템</title>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/comments.css">
</head>
<body style="background-color: #000000">
	<div id="wrap">
		<div id="header">
			<div id="userid"><%=request.getParameter("userName")%></div>
			<a id="writeButton" class="btn btn-default leftbutton">글쓰기</a>
			<hr id="underline" />
		</div>

		<hr id="underline" />

		<div id="content">

			<div class="table-responsive">
				<table class="table table-striped">
					<tbody>
						<tr>
							<td class="rightalign">한명승</td>
							<td class="centeralign">취업준비하려고 함</td>
							<td class="centeralign"><a href="#" class="btn btn-default">찬성(10)</a>&nbsp<a
								href="#" class="btn btn-default">반대(10)</a> <a href="#"
								class="btn btn-default">삭제</a></td>
							<td>15:03</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>

	</div>

	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		var userId = $("#userid");
		if (userId.text() == "null") {
			userId.innerHTML = "";
		}
		$("#writeButton").click("click", function() {
			var userId = $("#userid");
			if (userId.text() == "") {
				window.location = "login.jeju";
			} else {
				window.location = "writecomment.jeju";
			}
		});
	</script>
</body>
</html>