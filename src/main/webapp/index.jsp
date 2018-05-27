<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="校园合伙人">
    <meta name="author" content="gbtags.com">
    <title>首页</title>
    <link href="${cps}/static/index/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/animate.css" rel="stylesheet"/>
    <link href="${cps}/static/index/css/style.css" rel="stylesheet">
    <link href="${cps}/static/index/css/default.css" rel="stylesheet">
    <style>
        .table > thead > tr > th,
        .table > tbody > tr > th,
        .table > tfoot > tr > th,
        .table > thead > tr > td,
        .table > tbody > tr > td,
        .table > tfoot > tr > td {
            border-top: none;
        }

        .table-bordered > thead > tr > th,
        .table-bordered > tbody > tr > th,
        .table-bordered > tfoot > tr > th,
        .table-bordered > thead > tr > td,
        .table-bordered > tbody > tr > td,
        .table-bordered > tfoot > tr > td {
            border: none;
        }

        .table-bordered {
            border: none;
        }
    </style>
</head>
<style>
    body {
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none
    }
</style>
<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<!-- Preloader -->
<div id="preloader">
    <div id="load"></div>
</div>
<nav class="navbar navbar-custom navbar-fixed-top navbar-fixed-top-color" role="navigation">
    <div class="container">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="${cps}/index/index.do">
                <h1>校园合伙人</h1>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="${cps}/index/index.do">首页</a>
                </li>
                <li class="">
                    <a href="${cps}/index/userList.do">找人</a>
                </li>
                <li class="">
                    <a href="${cps}/index/projectList.do">找项目</a>
                </li>
                <li class="">
                    <a href="${cps}/index/projectList.do?progress=100">历史项目</a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.user==null}">
                        <li style="margin-right: 30px;">
                            <a href="${cps}/loginIndex.jsp">登录/注册</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.user.nickname}<b class="caret"></b>
                                <c:if test="${RprojectInfoBadge > 0 || ReceiveMessageBage > 0}">
                                    <span class="badge" style="color : red;">!</span>
                                </c:if>
                            </a>
                            <ul class="dropdown-menu">
                                <li class=""><a
                                        href="${cps}/user/userselfInfo.do">个人中心</a></li>
                                <li class=""><a
                                        href="${cps}/focus/focusList.do">我的关注</a></li>
                                <li class=""><a
                                        href="${cps}/message/receiveMessageList.do">我的私信
                                    <c:if test="${ReceiveMessageBage > 0}">
                                        <span class="badge" style="color : red;">!</span>
                                    </c:if>
                                </a></li>
                                <li class="divider"></li>
                                <li><a href="${cps}/logoutIndex.do">退出登录</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Section: intro -->
<section id="intro" class="intro"
         style="width: 100%; position: relative; background: url(${cps}/static/index/images/bg1.jpg) no-repeat top center;">
    <div class="slogan">
        <h2>
            欢迎来到 <span class="text_color">校园合伙人</span>
        </h2>
        <h4>在这里你可以找到机会！在这里你可以找到志同道合的朋友！</h4>
    </div>
    <div class="page-scroll">
        <a href="#service" class="btn btn-circle"> <i class="fa fa-angle-double-down animated"></i>
        </a>
    </div>
</section>
<!-- /Section: intro -->

<!-- Section: about -->
<section id="about" class="home-section text-center">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>最新合伙人</h2>
                            <i class="fa fa-2x fa-angle-down"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-lg-offset-5">
                <hr class="marginbot-50">
            </div>
        </div>
        <div class="row">
            <c:forEach var="userExtends" items="${userExtendsList}">
                <div class="col-xs-6 col-sm-3 col-md-3">
                    <div class="wow bounceInUp" data-wow-delay="0.2s">
                        <div class="team boxed-grey">
                            <div class="inner">
                                <a href="${cps}/index/showUser.do?userid=${userExtends.userid}">
                                    <h5>昵称：${userExtends.nickname}</h5>
                                    <p class="subtitle">主要技能：${userExtends.skillMajor.skillname}</p>
                                    <div class="avatar">
                                        <center>
                                            <img style="width: 150px; height: 150px;" draggable="false"
                                                 src="${cps}/mysrc/${userExtends.userimage}"
                                                 alt="" class="img-responsive img-circle"/>
                                        </center>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- /Section: about -->

<!-- Section: services -->
<section id="service" class="home-section text-center bg-gray">
    <div class="heading-about">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>最新项目</h2>
                            <i class="fa fa-2x fa-angle-down"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-lg-offset-5">
                <hr class="marginbot-50">
            </div>
        </div>
        <div class="row">
            <c:forEach var="projectExtends" items="${projectExtendsList}">
                <div class="col-xs-6 col-sm-3 col-md-3">
                    <div class="wow bounceInUp" data-wow-delay="0.4s">
                        <div class="team boxed-write">
                            <div class="inner">
                                <a href="${cps}/index/showProject.do?projectid=${projectExtends.projectid}">
                                    <h5>
                                        <p class="subtitle">${projectExtends.type.typename} 项目类型</p>
                                        发布人:${projectExtends.userExtends.nickname}
                                    </h5>
                                    <div class="avatar">
                                        <center>
                                            <img style="width: 150px; height: 150px;" draggable="false"
                                                 src="${cps}/mysrc/${projectExtends.projectimage}"
                                                 alt="" class="img-responsive img-circle"/>
                                        </center>
                                    </div>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- /Section: services -->

<!-- Section: contact -->
<section id="contact" class="home-section text-center">
    <div class="heading-contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="wow bounceInDown" data-wow-delay="0.4s">
                        <div class="section-heading">
                            <h2>意见反馈</h2>
                            <i class="fa fa-2x fa-angle-down"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-lg-offset-5">
                <hr class="marginbot-50">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8">
                <div class="boxed-grey">
                    <form id="contact-form" action="${cps}/feedback/saveFeedback.do" method="post">
                        <div class="row">
                            <div class="col-md-6">
                                <%--<div class="form-group">
                                    <label for="email">请输入您的邮箱地址</label>
                                    <div class="input-group">
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-envelope"></span>
                                        </span>
                                        <input type="email" name="email" class="form-control" id="email"
                                            placeholder="请输入您的邮箱地址便于联系" required="required"/>
                                    </div>
                                </div>--%>
                                <div class="form-group">
                                    <label for="subject">反馈主题</label>
                                    <select id="subject" name="type" class="form-control" required="required">
                                        <option selected="selected" value="暂无">请选择一个反馈的问题类型:</option>
                                        <option value="网站性能">网站性能</option>
                                        <option value="网站内容">网站内容</option>
                                        <option value="其他">其他</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="content">内容</label>
                                    <textarea id="content" name="content" class="form-control" rows="9" cols="25" required="required"
                                              placeholder="请输入反馈内容"></textarea>
                                </div>
                            </div>
                            <div class="col-md-12">
                                    <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">反馈</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="widget-contact">
                    <h5>Main Office</h5>
                    <address>
                        <strong>Squas Design, Inc.</strong><br> Tower 795 Folsom
                        Ave, Beautiful Suite 600<br> San Francisco, CA 94107<br>
                        <abbr title="Phone">P:</abbr> (123) 456-7890
                    </address>

                    <address>
                        <strong>Email</strong><br> <a href="mailto:#">email.name@example.com</a>
                    </address>
                    <address>
                        <strong>We're on social networks</strong><br>
                        <ul class="company-social">
                            <li class="social-facebook"><a href="#" target="_blank"><i
                                    class="fa fa-facebook"></i></a></li>
                            <li class="social-twitter"><a href="#" target="_blank"><i
                                    class="fa fa-twitter"></i></a></li>
                            <li class="social-dribble"><a href="#" target="_blank"><i
                                    class="fa fa-dribbble"></i></a></li>
                            <li class="social-google"><a href="#" target="_blank"><i
                                    class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </address>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /Section: contact -->
<footer style="background-color:#202896">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <div class="wow shake" data-wow-delay="0.4s">
                    <div class="page-scroll marginbot-30">
                        <a href="#intro" id="totop" class="btn btn-circle">
                            <i class="fa fa-angle-double-up animated"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<%-- 模态框 --%>
<div class="modal fade" id="myModal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">提示框</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- 模态框主体 -->
            <div class="modal-body">
                ${message}
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- Core JavaScript Files -->
<script src="${cps}/static/index/js/jquery.min.js"></script>
<script src="${cps}/static/index/js/bootstrap.min.js"></script>
<script src="${cps}/static/index/js/popper.min.js"></script>
<script src="${cps}/static/index/js/jquery.easing.min.js"></script>
<script src="${cps}/static/index/js/jquery.scrollTo.js"></script>
<script src="${cps}/static/index/js/wow.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        if(${message!=null}){
            $('#myModal').modal('show');
        }
    });

    (function ($) {
            new WOW().init();
            jQuery(window).load(function () {
                jQuery("#preloader").delay(100).fadeOut("slow");
                jQuery("#load").delay(100).fadeOut("slow");
            });
            // jQuery to collapse the navbar on scroll
            $(window).scroll(function () {
                if ($(".navbar").offset().top > 50) {
                    $(".navbar-fixed-top-color").css("background-color", "#202896");
                } else {
                    $(".navbar-fixed-top-color").removeAttr("style");
                }
            });
            // jQuery for page scrolling feature - requires jQuery Easing plugin
            $(function () {
                $('.navbar-nav li a').bind('click', function (event) {
                    var $anchor = $(this);
                    $('html, body').stop().animate({
                        scrollTop: $($anchor.attr('href')).offset().top
                    }, 1500, 'easeInOutExpo');
                    event.preventDefault();
                });
                $('.page-scroll a').bind('click', function (event) {
                    var $anchor = $(this);
                    $('html, body').stop().animate({
                        scrollTop: $($anchor.attr('href')).offset().top
                    }, 1500, 'easeInOutExpo');
                    event.preventDefault();
                });
            });
        }

    )(jQuery);
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fac45a0f68a119fbe4d1c4c3ac3044dbd' type='text/javascript'%3E%3C/script%3E"));
</script>
<%
    request.removeAttribute("message");
%>
</body>
</html>
