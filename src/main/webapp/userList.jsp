<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/3
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="校园合伙人">
    <meta name="author" content="gbtags.com">
    <title>人才列表</title>
    <link href="${cps}/static/index/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/animate.css" rel="stylesheet"/>
    <link href="${cps}/static/index/css/style.css" rel="stylesheet">
    <link href="${cps}/static/index/css/default.css" rel="stylesheet">
    <link href="${cps}/static/index/css/select/select2.css" rel="stylesheet">
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
<style>
    li {
        text-align: center;
    }
</style>
<body id="intro">


<div style="padding-bottom: 100px;">
    <nav class="navbar navbar-custom navbar-fixed-top" style="background-color:#202896">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand"
                   href="${cps}/index/index.do">
                    <h1>校园合伙人</h1>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div
                    class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <li class="">
                        <a href="${cps}/index/index.do">首页</a></li>
                    <li class="active">
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
</div>
<!-- 筛选 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="row">
                <div class="col-lg-6"></div>
                <div style="float: right;">
                    <form class="form-inline" action="${cps}/index/userList.do" method="post">
                        <label for="sel1">学校:</label>
                        <select class="form-control" name="school" id="sel1">
                            <option value="">请选择...</option>
                            <c:forEach var="school" items="${schoolList}">
                                <option value="${school.schoolid}">${school.schoolname}</option>
                            </c:forEach>
                        </select>
                        <label for="sel2">技能:</label>
                        <select class="form-control" name="skill" id="sel2">
                            <option value="">请选择...</option>
                            <c:forEach var="skill" items="${skillList}">
                                <option value="${skill.skillid}">${skill.skillname}</option>
                            </c:forEach>
                        </select>
                        <label for="sel3">性别:</label>
                        <select class="form-control" name="gender" id="sel3">
                            <option value="">请选择...</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                        <label for="nickname">昵称:</label>
                        <input type="text" class="form-control" name="nickname" placeholder="根据昵称进行搜索.." id="nickname">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </form>
                </div>
            </div>
            <br />
            <table class="table table-condensed table-striped"
                   style="background-color: #f5f5f5;">
                <tr class="active" align="center">
                    <td></td>
                </tr>
            </table>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
<!-- 人才列表 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <ol class="list-unstyled list-inline">
                <c:forEach var="userExtends" items="${userExtendsList}">
                    <li><a target="_blank"
                           href="${cps}/index/showUser.do?userid=${userExtends.userid}">
                        <img style="height: 150px; width: 150px"
                             src="${cps}/mysrc/${userExtends.userimage}" /><br />
                        昵称：${userExtends.nickname}<br />
                        技能：${userExtends.skillMajor.skillname}
                    </a>
                    </li>
                </c:forEach>

            </ol>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" align="center">
            <ul class="pagination pagination-lg">
                <%-- 首页 --%>
                <c:choose>
                    <c:when test="${pageData.isFirstPage}">
                        <li class="disabled"><a href="#">Prev</a></li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${cps}/index/userList.do?page=${pageData.pageNum-1}&school=${iusd.school}&skill=${iusd.skill}&gender=${iusd.gender}&nickname=${iusd.nickname}">Prev</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <%-- 页码 --%>
                <c:forEach var="pageSize" begin="1" end="${pageData.pages}">
                    <c:choose>
                        <c:when test="${pageData.pageNum==pageSize}">
                            <li class="active"><a href="#">${pageSize}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="">
                                <a href="${cps}/index/userList.do?page=${pageSize}&school=${iusd.school}&skill=${iusd.skill}&gender=${iusd.gender}&nickname=${iusd.nickname}">${pageSize}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <%-- 尾页 --%>
                <c:choose>
                    <c:when test="${pageData.isLastPage}">
                        <li class="disabled"><a href="#">Next</a></li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <a href="${cps}/index/userList.do?page=${pageData.pageNum+1}&school=${iusd.school}&skill=${iusd.skill}&gender=${iusd.gender}&nickname=${iusd.nickname}">Next</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
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
<script src="${cps}/static/index/js/select/select2.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#sel1").select2();
        $("#sel2").select2();
        $("#sel3").select2();
    })

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
