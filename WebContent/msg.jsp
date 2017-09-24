<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>易晨刷题助手-登录</title>
<link rel="icon" href="images/logo.png" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:choose>
	<c:when test="${result == 1 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/login.jsp">
	</c:when>
	<c:when test="${result == 2 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/index.jsp">
	</c:when>
	<c:when test="${result == 3 }">
		<meta http-equiv="refresh"
			content="3;${pageContext.request.contextPath }/index.jsp">
	</c:when>
</c:choose>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">YCPT</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}/index.jsp">主页
								<span class="sr-only">(current)</span>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="jumbotron">
			<h2>提示</h2>
			<p>${msg }</p>
			<p>3秒后自动跳转, 请等待……</p>
		</div>
	</div>
</body>

</html>