<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta content="initial-scale=1, shrink-to-fit=no, width=device-width"
	name="viewport">
<!-- CSS -->
<!-- Add Material font (Roboto) and Material icon as needed -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i,700,700i"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta charset="utf-8" />
<link href="css/material.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/material.min.js"></script>
<link rel="icon" href="images/logo.png" type="image/x-icon" />
<title>易晨刷题助手-登录</title>
</head>

<body style="width: 100%; height: 100%; background-color: #424242;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand">YCPT</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/index.jsp">主页<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item active"><a class="nav-link">登录</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<form method="post"
			action="${ pageContext.request.contextPath}/webLogin">
			<div class="form-group row">
				<label for="inputEmail3" class="col-sm-2 col-form-label">电子邮箱</label>
				<div class="col-sm-10">
					<input name="email" type="email" class="form-control "
						id="inputEmail3" placeholder="请输入电子邮箱">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputPassword3" class="col-sm-2 col-form-label">密码</label>
				<div class="col-sm-10">
					<input name="password" type="password" class="form-control"
						id="inputPassword3" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">立即登录</button>
				</div>
			</div>
		</form>
	</div>
</body>

</html>