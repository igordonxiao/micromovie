<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>微影视站</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/video-js.css" rel="stylesheet">
<link href="css/video.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/unslider.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-wysiwyg.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="navbar navbar-fixed-top">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a data-target=".navbar-responsive-collapse"
								data-toggle="collapse" class="btn btn-navbar"><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span></a> <a href="#" class="brand">微影视</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li class="active"><a href="#">主页</a></li>
									<li><a href="#">博客</a></li>
									<li><a href="#">相册</a></li>
									<li><a href="#">讨论</a></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">更多<strong class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="#">悦读</a></li>
											<li><a href="#">泛欧西</a></li>
											<li class="divider"></li>
											<li class="nav-header">兴趣</li>
											<li><a href="#">关注</a></li>
											<li><a href="#">最热</a></li>
										</ul></li>
								</ul>
								<ul class="nav pull-right">
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">用户<strong class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="#">个人资料</a></li>
											<li><a href="#">绑定手机</a></li>
											<li><a href="#">更改密码</a></li>
											<li class="divider"></li>
											<li><a href="#">注销</a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>
			</div>
		</div>
		<div class="fix-space50"></div>
		<div class="row-fluid">
			<div class="span12">
				<div class="carousel slide" id="carousel-0">
					<ol class="carousel-indicators">
						<li data-slide-to="0" data-target="#carousel-0"></li>
						<li data-slide-to="1" data-target="#carousel-0" class="active"></li>
						<li data-slide-to="2" data-target="#carousel-0"></li>
					</ol>
					<div class="carousel-inner">
						<c:forEach items="${requestScope.vs}" var="video"
							varStatus="status">
							<c:choose>
								<c:when test="${status.index eq 0}">
									<div class="item">
										<img alt="" src="${video.img}" />
										<div class="carousel-caption">
											<h4>${video.name}</h4>
											<p>${video.intro}</p>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="item">
										<img alt="" src="${video.img}" />
										<div class="carousel-caption">
											<h4>${video.name}</h4>
											<p>${video.intro}</p>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					<a data-slide="prev" href="#carousel-0"
						class="left carousel-control">‹</a> <a data-slide="next"
						href="#carousel-0" class="right carousel-control">›</a>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span12">
							<div class="tabbable" id="tabs-154391">
								<ul class="nav nav-tabs">
									<c:forEach items="${requestScope.vs}" var="video"
										varStatus="status">
										<c:choose>
											<c:when test="${status.index eq 0}">
												<li class="active"><a href="#panel-${status.index}"
													data-toggle="tab">${video.name}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="#panel-${status.index}" data-toggle="tab">${video.name}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</ul>
								<div class="tab-content">
									<c:forEach items="${requestScope.vs}" var="video"
										varStatus="status">
										<c:choose>
											<c:when test="${status.index eq 0}">
												<div class="tab-pane active" id="panel-${status.index}">
													<p>${video.vdesc}</p>
													<button class="play btn btn-success" vid="${video.id}" vpath="${video.path}">播放</button>
												</div>
											</c:when>
											<c:otherwise>
												<div class="tab-pane" id="panel-${status.index}">
													<p>${video.vdesc}</p>
													<button class="play btn btn-success" vid="${video.id}" vpath="${video.path}">播放</button>
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr class="soften" />
			</div>
		</div>
		<div id="videoDiv">
			<div class="container playzone">
				<div class="row-fluid">
					<div class="span12">
						<div id="myvideo">
						</div>
					</div>
				</div>
			</div>
			<hr class="soften" />
			<div>
				<div class="container">
					<div class="row-fluid">
						<div id="comments" class="span12">
								
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12"></div>
			<hr class="soften">
		</div>
		<div class="row-fluid">
			<div class="span12"></div>
		</div>
	</div>
	<div class="fix-space50"></div>
	<footer>
		<div class="container">
			<div class="span12">
				<div class="contact">
					<img src="images/picture.jpg" class="profile img-circle">
					<h4>Kevin Shaw，程序猿一枚</h4>
					<h5>摩羯座</h5>
					<hr class="soften">
					<p>
						<span class="hidden-phone">可以通过以下方法联系我，</span>欢迎访问<a
							target="_blank" href="#">我的博客</a>
					</p>
					<div class="padding-large">
						<div class="sns">
							<div class="sns-container">
								<a target="_blank" href="http://twitter.com/igordonshaw"><div
										title="" data-toggle="tooltip" class="sns-icon"
										id="icon-twitter" data-original-title="Twitter">
										<img src="images/sns/twitter.png">
									</div></a> <a target="_blank" href="http://weibo.com/hikevin"><div
										title="" data-toggle="tooltip" class="sns-icon"
										id="icon-sinaweibo" data-original-title="新浪微博">
										<img src="images/sns/SinaWeibo.png">
									</div></a> <a target="_blank" href="http://t.qq.com/gordonshaw"><div
										title="" data-toggle="tooltip" class="sns-icon"
										id="icon-tencentweibo" data-original-title="腾讯微博">
										<img src="images/sns/TencentWeibo.png">
									</div></a> <a target="_blank" title="916669975" href="javascript:;"><div title=""
										data-toggle="tooltip" class="sns-icon" id="icon-qq"
										data-original-title="916669975">
										<img src="images/sns/qq.png">
									</div></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>