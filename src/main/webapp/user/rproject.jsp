<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/8
  Time: 14:42
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
    <title>项目发布详情编辑</title>
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
                <li><a
                       href="${cps}/user/userselfInfo.do">个人资料</a></li>
                <li><a
                        href="${cps}/user/editUserselfInfo.do">编辑个人资料</a></li>
                <li><a
                        href="${cps}/cuser/editCuserselfInfo.do">实名认证</a></li>
                <li><a
                        href="${cps}/user/updateUserPasswordInfo.do">修改密码</a></li>
                <li class="nav-header">功能列表</li>
                <li><a style="background-color: #deded4"
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
            <c:choose>
                <c:when test="${message!=null}">
                    ${message}
                    <a href="${cps}/cuser/editCuserselfInfo.do">
                    <button class="btn btn-warning" type="button"
                            style="margin-top: 30px; width: 100px;">前去认证</button>
                    </a>
                </c:when>
                <c:otherwise>
                    <form method="post" enctype="multipart/form-data" action="${cps}/project/saveRproject.do">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <td>图片介绍
                                    <div id="imgDiv">
                                        <img id="img" style="width: 80px;" src="#">
                                    </div>
                                    <input type="file" onChange="setImagePreview(this,imgDiv,img);" name="file">
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="input-group">
                                        <span class="input-group-addon">项目名称</span>
                                        <input type="text" name="projectname" value=""
                                               class="form-control" placeholder="请输入当前项目名称(请保持在1~20个字符以内)" minlength="1" maxlength="20" required="required">
                                    </div>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="input-group">
                                        <span class="input-group-addon">项目类型</span>
                                        <select class="form-control" name="projecttype">
                                            <option value="" selected="selected">请选择...</option>
                                            <c:forEach var="projectType" items="${projectTypeList}">
                                                <option value="${projectType.typeid}">${projectType.typename}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="input-group">
                                        <span class="input-group-addon">项目需求</span>
                                        <textarea maxlength="500" rows="4" name="demand"
                                                  class="form-control"
                                                  placeholder="请输入项目需求（例如：小组成员需精通面向对象的分析与设计，会sql查询语句的优化，对MVC模式要有深入的了解等）(请保持在1~100个字符以内)"
                                                  required="required"></textarea>
                                    </div>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="input-group">
                                        <span class="input-group-addon">项目介绍</span>
                                        <textarea maxlength="500" rows="4" name="introduction"
                                                  class="form-control"
                                                  placeholder="请输入项目介绍（例如：本系统是基于SSM框架的图书管理系统，是一个由人、计算机等组成的能进行管理信息的收集、传递、加工、保存、维护和使用的系统。利用信息控制企业的行为；帮助企业实现其规划目标）(请保持在1~100个字符以内)"
                                                  required="required"></textarea>
                                    </div>
                                </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><div class="input-group">
                                    <span class="input-group-addon">需要人数</span>
                                    <input type="number" maxlength="10" name="numbers" class="form-control" min="0"
                                           value="" placeholder="请输入项目需要人数 " required="required" />
                                </div></td>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>

                        <button class="btn btn-success" type="submit"
                                style="margin-top: 30px; width: 100px;">发布</button>
                            <%--<button class="btn btn-default"--%>
                            <%--style="margin-top: 30px; width: 100px;"--%>
                            <%--onClick="javascript :history.back(-1);">返回</button>--%>
                    </form>
                </c:otherwise>
            </c:choose>
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

<SCRIPT
        LANGUAGE="JavaScript">
    function setImagePreview(docObj, localImagId, imgObjPreview) {

        var name = docObj.value;
        var type = name.split(".");
        type = type[type.length - 1];
        if ("jpg" != type && "png" != type && "jpeg" != type
            && "gif" != type) {
            alert("错误的类型，请选择图片");
            document.getElementById("txtSrc").value = null;//防止将非图片类型上传
            return;
        }

        if (docObj.files && docObj.files[0]) {

            //alert("hello"+docObj.files[0]);
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            document.getElementById("imgDiv").style.display = "block";
            document.getElementById("img").src = window.URL
                .createObjectURL(docObj.files[0]);
        } else {
            //IE下，使用滤镜
            docObj.select();
            var imgSrc = document.selection.createRange().text;

            //必须设置初始大小
            localImagId.style.width = "80px";
            localImagId.style.height = "80px";

            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters
                    .item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }
</SCRIPT>
</body>
</html>
