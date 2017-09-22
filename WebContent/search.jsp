<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>易晨刷题助手-搜索</title>
<title></title>
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
			</ul>
		</div>
		<form class="form-inline"
			action="${pageContext.request.contextPath}/webSearch" method="post">
			<input name="search" class="form-control mr-sm-2" type="search"
				placeholder="请输入题目" aria-label="Search"> <input
				type="submit" class="btn btn-outline-success my-2 my-sm-0"
				value="搜索" />
		</form>
	</nav>

	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">问题</th>
				<th scope="col">正确答案</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${test }" var="n" varStatus="cs">
				<tr>
					<th scope="row">${cs.index }</th>
					<td>${n.question }</td>
					<td>${n.ok }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>

</html>