<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/3
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="校园合伙人">
    <meta name="author" content="gbtags.com">
    <title>用户详情</title>
    <link href="${cps}/static/index/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/animate.css" rel="stylesheet"/>
    <link href="${cps}/static/index/css/style.css" rel="stylesheet">
    <link href="${cps}/static/index/css/default.css" rel="stylesheet">
    <style>
        .table>thead>tr>th,.table>tbody>tr>th,.table>tfoot>tr>th,.table>thead>tr>td,.table>tbody>tr>td,.table>tfoot>tr>td
        {
            border-top: none;
        }

        .table-bordered>thead>tr>th,.table-bordered>tbody>tr>th,.table-bordered>tfoot>tr>th,.table-bordered>thead>tr>td,.table-bordered>tbody>tr>td,.table-bordered>tfoot>tr>td
        {
            border: none;
        }
        .table-bordered {
            border: none;
        }
    </style>

</head>
<body id="intro">
<div style="padding-bottom: 100px;">
    <nav class="navbar navbar-custom navbar-fixed-top" style="background-color:#202896">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="${cps}/index/index.do">
                    <h1>校园合伙人</h1>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <li class=""><a
                            href="${cps}/index/index.do">首页</a></li>
                    <li class="">
                        <a href="${cps}/index/userList.do">找人</a></li>
                    <li class="">
                        <a href="${cps}/index/projectList.do">找项目</a></li>
                    <li class="">
                        <a href="${cps}/index/projectList.do?progress=100">历史项目</a></li>
                    <c:choose>
                        <c:when test="${sessionScope.user==null}">
                            <li style="margin-right: 30px;">
                                <a href="${cps}/loginIndex.jsp">登录/注册</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="dropdown active">
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
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <ul class="nav nav-list">
                <li class="nav-header">个人中心</li>
                <li><a style="background-color: #deded4"
                        href="${cps}/user/userselfInfo.do">个人资料</a></li>
                <li><a
                       href="${cps}/user/editUserselfInfo.do">编辑个人资料</a></li>
                <li><a
                       href="${cps}/cuser/editCuserselfInfo.do">实名认证</a></li>
                <li><a
                        href="${cps}/user/updateUserPasswordInfo.do">修改密码</a></li>
                <li class="nav-header">功能列表</li>
                <li><a
                        href="${cps}/project/rproject.do">发布项目</a></li>
                <li><a
                        href="${cps}/project/rprojectInfo.do">发布项目信息
                    <c:if test="${RprojectInfoBadge > 0}">
                        <span class="badge" style="color : red;">!</span>
                    </c:if>
                </a></li>
                <li><a
                        href="${cps}/project/aprojectInfo.do">我申请的项目</a></li>
                <li><a
                        href="${cps}/project/jprojectInfo.do">我参加的项目</a></li>
                <li><a
                        href="${cps}/focus/focusList.do">我关注的用户</a></li>
                <li class="divider"></li>
                <li class="nav-header">私信</li>
                <li><a
                        href="${cps}/message/receiveMessageList.do">我收到的私信
                    <c:if test="${ReceiveMessageBage > 0}">
                        <span class="badge" style="color : red;">!</span>
                    </c:if>
                </a></li>
                <li><a
                        href="${cps}/message/sendMessageList.do">我发送的私信</a></li>
                <li><a
                        href="${cps}/feedback/feedbackList.do">我反馈的信息</a></li>
                <li><a
                        href="https://www.baidu.com">帮助</a></li>
            </ul>
        </div>

        <div class="col-md-8">
            <table class="table table-condensed">
                <tbody>
                <tr>
                    <td>头像</td>
                    <td><img class="img-circle" draggable="false" style="width: 80px;"
                             src="${cps}/mysrc/${userExtends.userimage}"/></td>
                </tr>
                <tr>
                    <td>昵称</td>
                    <td>${userExtends.nickname}</td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>${userExtends.gender}</td>
                </tr>
                <tr>
                    <td>学校</td>
                    <td>${userExtends.userSchool.schoolname}</td>
                </tr>
                <tr>
                    <td>年级</td>
                    <td>${userExtends.userGrade.gradename}</td>
                </tr>
                <tr>
                    <td>专业</td>
                    <td>${userExtends.userProfessional.professionalname}</td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td>${userExtends.phonenumber}</td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>${userExtends.email}</td>
                </tr>
                <tr>
                    <td>QQ</td>
                    <td>${userExtends.qqnumber}</td>
                </tr>
                <tr>
                    <td>主技能</td>
                    <td>${userExtends.skillMajor.skillname}</td>
                </tr>
                <tr>
                    <td>副技能</td>
                    <td>${userExtends.skillMinor.skillname}</td>
                </tr>
                <tr>
                    <td>工作经验</td>
                    <td>${userExtends.experience}年</td>
                </tr>
                <tr>
                    <td>介绍</td>
                    <td>${userExtends.introduction}</td>
                </tr>
                </tbody>
            </table>
            <%--<a href="/SchoolPartner/views/user/users_edit.do"><button--%>
                    <%--type="button" class="btn btn-warning">编辑</button></a>--%>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>


<footer style="background-color:#202896">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <div class="wow shake" data-wow-delay="0.4s">
                    <div class="page-scroll marginbot-30">
                        <a href="#intro" id="totop" class="btn btn-circle"> <i
                                class="fa fa-angle-double-up animated"></i>
                        </a>
                    </div>
                </div>
                <!-- <p>&copy;Copyright 2014 - Squad. All rights reserved.</p>
                <p>-</p> -->
            </div>
        </div>
    </div>
</footer>

<!-- Core JavaScript Files -->
<script src="${cps}/static/index/js/jquery.min.js"></script>
<script src="${cps}/static/index/js/bootstrap.min.js"></script>
<script src="${cps}/static/index/js/jquery.easing.min.js"></script>
<script src="${cps}/static/index/js/jquery.scrollTo.js"></script>
<script src="${cps}/static/index/js/wow.min.js"></script>
<script type="text/javascript">
    (function($) {

        new WOW().init();

        jQuery(window).load(function() {
            jQuery("#preloader").delay(100).fadeOut("slow");
            jQuery("#load").delay(100).fadeOut("slow");
        });

        // jQuery to collapse the navbar on scroll
        $(window).scroll(function() {
            if ($(".navbar").offset().top > 50) {
                $(".navbar-fixed-top-color").css("background-color", "#202896");
            } else {
                $(".navbar-fixed-top-color").removeAttr("style");
            }
        });

        // jQuery for page scrolling feature - requires jQuery Easing plugin
        $(function() {
            $('.navbar-nav li a').bind('click', function(event) {
                var $anchor = $(this);
                $('html, body').stop().animate({
                    scrollTop : $($anchor.attr('href')).offset().top
                }, 1500, 'easeInOutExpo');
                event.preventDefault();
            });
            $('.page-scroll a').bind('click', function(event) {
                var $anchor = $(this);
                $('html, body').stop().animate({
                    scrollTop : $($anchor.attr('href')).offset().top
                }, 1500, 'easeInOutExpo');
                event.preventDefault();
            });
        });

    })(jQuery);

    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://"
        : " http://");
    document
        .write(unescape("%3Cscript src='"
            + _bdhmProtocol
            + "hm.baidu.com/h.js%3Fac45a0f68a119fbe4d1c4c3ac3044dbd' type='text/javascript'%3E%3C/script%3E"));
</script>

</body>
</html>
