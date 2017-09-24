<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>易晨刷题助手</title>
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
						<li class="active"><a>主页<span class="sr-only">(current)</span></a>
						</li>
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
			<h1>易晨刷题助手</h1>
			<p>我</p>
			<p>我们</p>
			<p>易晨团队</p>
			<p>助力鉴定考试</p>
			<p>预祝考生顺利考试</p>
			<p>
				<a class="btn btn-primary btn-lg" role="button"
					href="${pageContext.request.contextPath }/about.jsp"> 关于我们</a>
			</p>
		</div>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h2>最新消息</h2>
			<p>2017.9.24, 系统更新, 网站实行单点登录, 请不要将账号密码给予别人</p>
			<p>2017.9.23 晚上11点----2017.9.24 上午11点系统升级, 造成部分用户无法访问, 在此抱歉</p>
			<p>2017.9.18, 新增20道2016年考试题目</p>
			<p>2017.9.12, 开启网页版VIP服务</p>
			<p>2017.9.12, 开启职业技能鉴定搜题网页服务</p>
			<p>2017.9.06, 实行邮箱认证服务</p>
			<p>2017.9.05, Android背诵及刷题服务开启</p>
			<p>2017.9.04, 增加272道考试题目</p>
		</div>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h2>关于会员</h2>
			<p>网页不提供注册服务, 请使用Android YCPT进行注册</p>
			<p>APP可以进行背诵以及刷题, 网页版需要购买会员</p>
			<p>购买会员请发送您的联系方式到isreg@foxmail.com, 备注会员</p>
			<p>会员价格: 2元</p>
			<p>有效期: 购买日起至考试结束</p>
		</div>
	</div>
</body>
</html>