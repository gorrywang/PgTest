<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>易晨刷题助手-后台服务</title>
<link rel="icon" href="images/logo.png" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
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

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a>后台管理</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h2>注册账户</h2>
			<br />
			<form method="post"
				action="${ pageContext.request.contextPath}/registerManager">
				<div class="form-group">
					<label for="exampleInputName1">注册码</label> <input name="reg"
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="请输入中注册码">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">电子邮箱</label> <input name="email"
						type="email" class="form-control" id="exampleInputEmail1"
						placeholder="请输入电子邮箱">
				</div>
				<div class="form-group">
					<label for="exampleInputName1">用户名</label> <input name="username"
						type="text" class="form-control" id="exampleInputPassword1"
						placeholder="请输入用户名">
				</div>
				<div class="form-group">
					<label for="exampleInputName1">班级</label> <input name="cla"
						type="text" class="form-control" id="exampleInputPassword1"
						placeholder="请输入所在班级">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">密码</label> <input
						name="password" type="password" class="form-control"
						id="exampleInputPassword1" placeholder="请输入密码">
				</div>

				<button type="submit" class="btn btn-default">立即注册</button>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="jumbotron">
			<h2>充值会员</h2>
			<br />
			<form method="post"
				action="${ pageContext.request.contextPath}/vipManager">
				<div class="form-group">
					<label for="exampleInputName1">充值码</label> <input name="vip"
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="请输入中充值码">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">电子邮箱</label> <input name="email"
						type="email" class="form-control" id="exampleInputEmail1"
						placeholder="请输入电子邮箱">
				</div>
				<button type="submit" class="btn btn-default">立即充值</button>
			</form>
		</div>
	</div>


	<div class="container">
		<div class="jumbotron">
			<h2>取消会员</h2>
			<br />
			<form method="post"
				action="${ pageContext.request.contextPath}/cancelManager">
				<div class="form-group">
					<label for="exampleInputName1">授权码</label> <input name="cancel"
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="请输入授权码">
				</div>
				<button type="submit" class="btn btn-default">取消联想一班会员</button>
			</form>
		</div>
	</div>


	<div class="container">
		<div class="jumbotron">
			<h2>恢复会员</h2>
			<br />
			<form method="post"
				action="${ pageContext.request.contextPath}/reSetManager">
				<div class="form-group">
					<label for="exampleInputName1">恢复码</label> <input name="reset"
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="请输入授权码">
				</div>
				<button type="submit" class="btn btn-default">恢复购买者会员</button>
			</form>
		</div>
	</div>

	<div id="footer" class="container">
		<nav class="navbar navbar-default">
			<div class="navbar-inner navbar-content-center"
				style="text-align: center">
				<h5 class="text-muted credit" style="padding: 5px;">易晨网站 | 刷题助手
					| 技术支持</h5>
				<h5 class="text-muted credit" style="padding: 5px;">鲁ICP备17040550号-1</h5>
				<h5 class="text-muted credit" style="padding: 5px;">&copy;2016-2017</h5>
			</div>
		</nav>
	</div>
</body>

</html>