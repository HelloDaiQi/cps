<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/3
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>${projectExtends.type.typename} 项目类型-详情</title>
    <link href="${cps}/static/index/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/animate.css" rel="stylesheet"/>
    <link href="${cps}/static/index/css/style.css" rel="stylesheet">
    <link href="${cps}/static/index/css/default.css" rel="stylesheet">
    <style>

        /* 定义辅助CSS来美化简历头部 */
        body {
            font-family: 'microsoft yahei', Arial, sans-serif;
        }

        .cvheader {
            border-bottom: 1px solid #DFDFDF;
            padding-top: 30px;
            padding-bottom: 20px;
        }

        .cvheader h1 {
            margin: 0;
        }

        .address {
            background: #efb73e;
            color: #fff;
            padding: 10px 0;
        }

        /* 定义辅助CSS来美化简历主体 */
        .cvbody {
            padding-top: 50px;
        }

        .cbox {
            margin-bottom: 30px;
            color: #FFF;
            padding: 50px;
        }

        /* 定义cbox颜色 */
        .green {
            background: #2ecc71;
        }

        .orange {
            background: orange;
        }

        .red {
            background: #dd4814;
        }

        .bbox {
            border: 1px solid #DFDFDF;
            border-radius: 5px;
            margin-bottom: 30px;
            padding: 50px;
        }

        .footer {
            margin: 30px 0 30px;
            padding: 50px;
            background: #CCC;
            color: #FFF;
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
                <a class="navbar-brand"
                   href="${cps}/index/index.do">
                    <h1>校园合伙人</h1>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div
                    class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <li class=""><a
                            href="${cps}/index/index.do">首页</a></li>
                    <li class="">
                        <a href="${cps}/index/userList.do">找人</a></li>
                    <c:choose>
                        <c:when test="${applicationFlag == '项目结束'}">
                            <li class="">
                                <a href="${cps}/index/projectList.do">找项目</a></li>
                            <li class="active">
                                <a href="${cps}/index/projectList.do?progress=100">历史项目</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="active">
                                <a href="${cps}/index/projectList.do">找项目</a>
                            </li>
                            <li class="">
                                <a href="${cps}/index/projectList.do?progress=100">历史项目</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

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


<!-- 定义简历的头部 //-->
<div class="container">
    <div class="row cvheader">
        <div class="col-lg-9 col-md-9 col-xs-12">
            <!--  添加颜色//-->
            <h1 class="text-primary">${projectExtends.type.typename} 项目类型</h1>
            <br>
            <p>发布人：${projectExtends.userExtends.nickname}</p>
            <p>
                <span class="glyphicon glyphicon-envelope"></span>
                邮箱：${projectExtends.userExtends.email}
            </p>
            <p>
                <span class="glyphicon glyphicon-earphone"></span>
                电话：${projectExtends.userExtends.phonenumber}
            </p>
        </div>
        <div class="col-lg-3 col-md-3 col-xs-12">
            <p>
                <!-- 这里定义图片为响应式，并且添加圆角效果，以便保证图片在不同设备上都可以完美显示 //-->
                <img data-toggle="tooltip" data-placement="left" id="avatar" style="width:150px; height: 150px"
                     title="我是${projectExtends.userExtends.nickname}" class="img-responsive img-rounded"
                     src="${cps}/mysrc/${projectExtends.projectimage}" alt="">
            </p>
            <p>
                <c:choose>
                    <c:when test="${applicationFlag == '项目结束'}">
                        <button class="btn btn-default">项目结束</button>
                    </c:when>
                    <c:when test="${applicationFlag == '冻结'}">
                        <button class="btn btn-default">项目异常</button>
                    </c:when>
                    <c:when test="${applicationFlag == '审核中'}">
                        <button class="btn btn-default">正在审核</button>
                    </c:when>
                    <c:when test="${applicationFlag == '审核通过'}">
                        <button class="btn btn-default">您已加入</button>
                    </c:when>
                    <c:when test="${applicationFlag == '您是组长'}">
                        <button class="btn btn-default">您是组长</button>
                    </c:when>
                    <c:when test="${applicationFlag == '审核不通过'}">
                        <button class="btn btn-default" data-toggle="modal" data-target="#myModal">再次申请</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" data-toggle="modal" data-target="#myModal">申请加入</button>
                    </c:otherwise>
                </c:choose>
            </p>
        </div>
    </div>
</div>

<!-- 定义简历的主体部分 //-->
<div class="container">
    <div class="row cvbody">
        <!-- 这里定义两个区域，布局定义如下：//-->
        <div class="col-lg-6 col-md-6 col-xs-12">
            <div class="row">
                <div class="cbox green">
                    <h4>项目介绍</h4>
                    <p>项目类型: ${projectExtends.type.typename}</p>
                    <p>发布时间：${projectExtends.releasetime}</p>
                    <c:if test="${projectExtends.stoptime != null}">
                        <p>结束时间：${projectExtends.stoptime}</p>
                    </c:if>
                    <p>项目简介：${projectExtends.introduction}</p>
                    <p style="width:18%; float:left; display:inline;">项目进度：</p>
                    <div class="progress" style="width:82%; float:left; display:inline;">
                        <div class="progress-bar" style="width:${projectExtends.progress}%">${projectExtends.progress}%</div>
                    </div>
                </div>
                <div class="cbox red">
                    <h4>项目需求</h4>
                    <p>需要人数: ${projectExtends.numbers}(已参加人数:${joined}人)</p>
                    <p>${projectExtends.demand}</p>
                </div>
            </div>

        </div>

        <!-- 为了清楚的分割两个区域，这里我们添加了一个空白区域，或者也可以在CSS中定义Margin实现//-->
        <div class="col-lg-1 col-md-1 col-xs-12"></div>

        <div class="col-lg-5 col-md-5 col-xs-12">
            <div class="row">
                <h4>发布人信息</h4>
                <div class="bbox">
                    <h4>教育背景</h4>
                    <p>学校：${projectExtends.userExtends.userSchool.schoolname}</p>
                    <p>年级：${projectExtends.userExtends.userGrade.gradename}</p>
                    <p>专业：${projectExtends.userExtends.userProfessional.professionalname}</p>
                </div>
                <div class="bbox">
                    <h4>工作经验</h4>
                    <p>项目经验：${projectExtends.userExtends.experience}年</p>
                    <p><a href="${cps}/index/projectListOfUserRelease.do?releaser=${projectExtends.userExtends.userid}">发布项目</a>：${releaseNumber}个</p>
                    <p><a href="${cps}/index/projectListOfUserJoin.do?mumber=${userExtends.userid}">参加项目</a>：${joinNumber}个</p>
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
                <form id="contact-form" action="${cps}/message/sendMessage.do" method="post">
                    <input type="hidden" name="projectid" value="${projectExtends.projectid}" />
                    <input type="hidden" name="receiver" value="${projectExtends.releaser}">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="message">私信内容</label>
                                <textarea name="content" id="message" class="form-control"
                                          rows="9" cols="25" required="required" placeholder="请输入私信内容"></textarea>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-skin pull-right" id="btnContactUs">发送私信</button>
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
                    <strong>Email</strong><br> <a href="mailto:#">${projectExtends.userExtends.email}</a>
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
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">提示框</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- 模态框主体 -->
            <div class="modal-body">
                <c:choose>
                    <c:when test="${applicationFlag == '审核不通过'}">
                        <form action="${cps}/aproject/applyProject.do" method="post">
                            <input type="hidden" name="projectid" value="${projectExtends.projectid}" />
                            <input type="hidden" name="flag" value="applyAgain" />
                            <textarea name="reason" class="form-control" placeholder="请先登录哦" maxlength="100" rows="7" cols="15" required="required"></textarea>
                            <button type="submit" class="btn btn-success pull-right">提交</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="${cps}/aproject/applyProject.do" method="post">
                            <input type="hidden" name="projectid" value="${projectExtends.projectid}" />
                            <input type="hidden" name="flag" value="apply" />
                            <textarea name="reason" class="form-control" placeholder="请先登录哦" maxlength="100" rows="7" cols="15" required="required"></textarea>
                            <button type="submit" class="btn btn-success pull-right">提交</button>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<%-- 模态框 --%>
<div class="modal fade" id="myModal2">
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
<script src="${cps}/static/index/js/jquery.easing.min.js"></script>
<script src="${cps}/static/index/js/jquery.scrollTo.js"></script>
<script src="${cps}/static/index/js/wow.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        if(${message!=null}){
            $('#myModal2').modal('show');
        }
    });

    /*--------------------------------------*/
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
