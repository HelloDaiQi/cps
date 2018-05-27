<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/5
  Time: 10:28
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
    <title>用户认证</title>
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
                        <a href="${cps}/index/userList.do">找人</a>
                    </li>
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
                <li><a
                        href="${cps}/user/userselfInfo.do">个人资料</a></li>
                <li><a
                        href="${cps}/user/editUserselfInfo.do">编辑个人资料</a></li>
                <li><a style="background-color: #deded4"
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
            <form action="${cps}/cuser/saveCuserselfInfo.do" method="post">
                <div class="col-md-8">
                    <input name="cuserid" type="hidden" value="${cuser.cuserid}">
                    <input name="userid" type="hidden" value="${cuser.userid}">
                    <div>
                        <div class="input-group">
                            <span class="input-group-addon">真实姓名</span>
                            <input type="text" name="realname" value="${cuser.realname}" class="form-control"
                                   placeholder="请输入姓名" required="required">
                        </div>
                    </div>
                    <div>
                        <div class="input-group" style="margin-top: 30px">
                            <span class="input-group-addon">身份证号</span>
                            <input type="text" name="cardnumber" value="${cuser.cardnumber}" class="form-control"
                                   placeholder="请输入身份证号码" maxlength="18" required="required">
                        </div>
                    </div>
                    <div>
                        <div class="input-group" style="margin-top: 30px">
                            <span class="input-group-addon">认证理由</span>
                            <textarea class="form-control" maxlength="500" rows="4" name="reason"
                                      placeholder="请输入理由" required="required">${cuser.reason}</textarea>
                        </div>
                    </div>
                    <div>
                        <div class="input-group">
                            <span class="input-group-addon">审核意见</span>
                            <textarea maxlength="500" rows="4" name="opinion"
                                      class="form-control" placeholder="请勿填写..." readonly="readonly"
                                      required="required">${cuser.opinion}</textarea>
                        </div>
                    </div>
                </div>
                <c:choose>
                    <c:when test="${cuser!=null}">
                        <c:choose>
                            <c:when test="${cuser.status=='审核通过'}">
                                <div class="col-md-8" style="margin-top: 30px">
                                    您的认证信息审核通过！
                                </div>
                            </c:when>
                            <c:when test="${cuser.status=='审核中'}">
                                <div class="col-md-8" style="margin-top: 30px">
                                    您的认证信息审核中...
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-md-8" style="margin-top: 30px">
                                    您的审核信息不通过，请重新填写信息，再次申请...
                                    <button class="btn btn-success" type="submit"
                                            style="margin-top: 30px; width: 100px;">再次申请</button>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-8" style="margin-top: 30px">
                            您还没有填写认证信息，请填写完毕后点击申请按钮进行申请...
                            <button class="btn btn-success" type="submit"
                                    style="margin-top: 30px; width: 100px;">立即申请</button>
                        </div>
                    </c:otherwise>
                </c:choose>
            </form>
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

    /*-------------------------------------------------*/
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
<%
    request.removeAttribute("message");
%>
</body>
</html>
