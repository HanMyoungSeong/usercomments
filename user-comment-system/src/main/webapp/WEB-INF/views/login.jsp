<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>로그인</title>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/login.css">
</head>
<body>
	<div id="wrap">
		<div id="header">
			<h1>댓글시스템 로그인</h1>
		</div>
		<div id="content">
			<form class="form-horizontal" action="login" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label">ID</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="userName" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-5">
						<input type="password" class="form-control" name="password">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">로그인</button>
						<a href="comments.jeju" class="btn btn-default">취소</a>
					</div>
				</div>

			</form>
		</div>
	</div>

	<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</body>
</html>