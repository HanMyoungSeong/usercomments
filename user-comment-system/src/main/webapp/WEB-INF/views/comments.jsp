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
			<div id="userid" style="top: 30px; left:10px; position: relative;">${username}</div> 
			<a id="writeButton" class="btn btn-default leftbutton">글쓰기</a>
			<hr id="underline" />
		</div>

		<hr id="underline" />

		<div id="content"></div>

	</div>

	<script type="text/template" id="listTemplate">
			<div class="table-responsive">
				<table class="table table-striped">
					<tbody>
					<@ for(var i = 0 ; i < list.length; i++){ @>
						<tr>
							<td class="rightalign"><@=list[i].author@></td>
							<td class="centeralign"><@=list[i].comment@></td>
							<td class="centeralign">
								<a href="addRecommendation?commentId=<@=list[i].commentId@>" class="btn btn-default">찬성(<@=list[i].recommendation@>)</a>&nbsp
								<a href="addOpposition?commentId=<@=list[i].commentId@>" class="btn btn-default">반대(<@=list[i].opposition@>)</a>
							</td>
							<td>
						<@var id = ${id}@>
						<@	if(id === list[i].id)	{	@>
								<a href="deleteComment?commentId=<@=list[i].commentId@>" class="btn btn-default">삭제</a>
									
						<@	}	@>
							</td>
							<td><@=list[i].date@></td>
						</tr>

					<@ } @>
					</tbody>
				</table>
			</div>
	</script>
	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="http://underscorejs.org/underscore.js"></script>
	<script type="text/javascript" src="resources/js/config.js"></script>
	<script type="text/javascript" src="resources/js/commenter.js"></script>
	<script type="text/javascript" src="resources/js/main.js"></script>
	<script type="text/javascript">
		$("#writeButton").click("click", function() {
			var userId = $("#userid");
			if (userId.text() == "") {
				window.location = "login.jeju";
			} else {
				window.location = "addComment.jeju";
			}
		});
	</script>
</body>
</html>