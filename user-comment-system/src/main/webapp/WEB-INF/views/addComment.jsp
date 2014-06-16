<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" />
<title>글쓰기</title>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/writecomment.css">
</head>
<body style="background-color: #000000">
	<div id="wrap">
		<div id="header">
			<h1>글쓰기</h1>
		</div>
		<div id="content">
			<form action="writeComment" method="post">
				<div class="form-group">
					<label>댓글등록</label>
					<textarea type="text" class="form-control textareasize" rows="5" name="comment"></textarea>
				</div>
				<button type="submit" class="btn btn-default">저장</button>
				<a href="comments.jeju" class="btn btn-default">취소</a>
			</form>
		</div>
	</div>
</body>
</html>