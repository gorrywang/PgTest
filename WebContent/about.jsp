<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>易晨刷题助手-关于</title>
<link rel="icon" href="images/logo.png" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1">
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
						<li><a href="${pageContext.request.contextPath}/index.jsp">主页<span class="sr-only">(current)</span></a></li>
						<c:if test="${cookie.username == null }">
							<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a>
							</li>
						</c:if>
						<c:if test="${cookie.username != null }">
							<li><a>已经登录成功</a></li>
						</c:if>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<form class="navbar-form navbar-left"
								action="${pageContext.request.contextPath}/webSearch"
								method="post">
								<div class="form-group">
									<input name="search" type="text" class="form-control"
										placeholder="请输入关键词">
								</div>
								<button type="submit" class="btn btn-default">搜索</button>
							</form>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h1>关于我们</h1>
			<p>团队: 易晨团队</p>
			<p>班级: D15联想一班</p>
			<p>学校: 山东劳动职业技术学院</p>
			<p>电邮: isreg@foxmail.com</p>
			<p>
				<a class="btn btn-info" href="https://weibo.com/wgr1997"
					target="view_window">微博</a>
				<a class="btn btn-info"
					href="http://github.com/gorrywang" target="view_window">GitHub</a>
				<a class="btn btn-info" href="http://blog.csdn.net/qq_26239671"
					target="view_window">CSDN</a>
				<a class="btn btn-info"
					href="http://www.eachwang.com" target="view_window">易晨网</a>
			</p>


		</div>
	</div>

</body>
</html>