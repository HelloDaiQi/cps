<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/3
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>登录页面</title>

    <meta name="description" content="User login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${cps}/static/index/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${cps}/static/index/css/font-awesome.min.css" />
    <!-- text fonts -->
    <link rel="stylesheet" href="${cps}/static/index/css/fonts.googleapis.com.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="${cps}/static/index/css/ace.min.css" />
    <link rel="stylesheet" href="${cps}/static/index/css/ace-rtl.min.css" />
</head>
<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="ace-icon fa fa-leaf green"></i> <span class="red">Partner</span>
                            <span class="white" id="id-text2"></span>
                        </h1>
                        <h4 class="blue" id="id-company-text">&copy; 校园合伙人</h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box"
                             class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="ace-icon fa fa-coffee green"></i> 请输入您的信息
                                    </h4>

                                    <div class="space-6"></div>
                                    <!-- 试试能不能实现记住密码功能 -->
                                    <%
                                        Cookie[] cookies = request.getCookies();
                                        String autologin = null;
                                        for(int i=0;cookies!=null&&i<cookies.length;i++){
                                            if("user".equals((cookies[i].getName()))){
                                                autologin = cookies[i].getValue();
                                                break;
                                            }
                                        }
                                        if(autologin!=null && autologin!=""){
                                            String[] split = autologin.split("-");
                                            pageContext.setAttribute("email",split[0]);
                                            pageContext.setAttribute("password",split[1]);
                                        }
                                    %>
                                    <form action="${cps}/loginIndex.do" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="email" type="text" class="form-control"
                                                        placeholder="请输入邮箱" value="${pageContext.getAttribute("email")}" required="required" />
                                                    <i class="ace-icon fa fa-user"></i>
												</span>
                                            </label>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="password" type="password" class="form-control"
                                                        placeholder="请输入密码" value="${pageContext.getAttribute("password")}" required="required" />
                                                    <i class="ace-icon fa fa-lock"></i>
												</span>
                                            </label>
                                            <div class="space"></div>
                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input type="checkbox" name="remember" value="true" checked="checked" class="ace" /> <span class="lbl">记住</span>
                                                </label>

                                                <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="ace-icon fa fa-key"></i>
                                                    <span class="bigger-110">登录</span>
                                                </button>
                                            </div>
                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                    <div class="social-or-login center">
                                        <span class="bigger-110">第三方登录</span>
                                    </div>

                                    <div class="space-6"></div>

                                    <div class="social-login center">
                                        <a class="btn btn-primary"> <i
                                                class="ace-icon fa fa-facebook"></i>
                                        </a> <a class="btn btn-info"> <i
                                            class="ace-icon fa fa-twitter"></i>
                                    </a> <a class="btn btn-danger"> <i
                                            class="ace-icon fa fa-google-plus"></i>
                                    </a>
                                    </div>
                                </div>
                                <!-- /.widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="#" data-target="#forgot-box"
                                           class="forgot-password-link"> <i
                                                class="ace-icon fa fa-arrow-left"></i> 忘记密码
                                        </a>
                                    </div>

                                    <div>
                                        <a href="#" data-target="#signup-box"
                                           class="user-signup-link"> 注册 <i
                                                class="ace-icon fa fa-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <!-- /.widget-body -->
                        </div>
                        <!-- /.login-box -->

                        <div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="ace-icon fa fa-key"></i>找回密码
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>输入您的电子邮件和接收指令</p>

                                    <form action="${cps}/resetPassword.do" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="email" type="email" class="form-control" placeholder="Email" />
														<i class="ace-icon fa fa-envelope"></i>
												</span>
                                            </label>

                                            <div class="clearfix">
                                                <button type="submit"
                                                        class="width-35 pull-right btn btn-sm btn-danger">
                                                    <i class="ace-icon fa fa-lightbulb-o"></i> <span
                                                        class="bigger-110">发送邮件</span>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>
                                <!-- /.widget-main -->

                                <div class="toolbar center">
                                    <a href="#" data-target="#login-box"
                                       class="back-to-login-link"> 返回登录 <i
                                            class="ace-icon fa fa-arrow-right"></i>
                                    </a>
                                </div>
                            </div>
                            <!-- /.widget-body -->
                        </div>
                        <!-- /.forgot-box -->

                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="ace-icon fa fa-users blue"></i>用户注册
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>填写信息:</p>
                                    <form action="${cps}/registerIndex.do" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="email" type="email" class="form-control"
                                                        placeholder="邮箱" required="required" />
                                                    <i class="ace-icon fa fa-envelope"></i>
												</span>
                                            </label>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="nickname" type="text" class="form-control"
                                                        placeholder="昵称" required="required" />
                                                    <i class="ace-icon fa fa-user"></i>
												</span>
                                            </label>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input id="password" name="password" type="password" class="form-control"
                                                        placeholder="密码" required="required" />
                                                    <i class="ace-icon fa fa-lock"></i>
												</span>
                                            </label>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input id="repassword" type="password" class="form-control" placeholder="确认密码"
                                                        required="required" data-toggle="tooltip" data-placement="top" title="密码必须一致" />
                                                    <i class="ace-icon fa fa-retweet"></i>
												</span>
                                            </label>
                                            <label class="block">
                                                <input type="checkbox" class="ace" name="isChecked" value="true" required="required" />
                                                <span class="lbl">接受 <a href="#">用户协议</a></span>
                                            </label>

                                            <div class="space-24"></div>

                                            <div class="clearfix">
                                                <button type="reset" class="width-30 pull-left btn btn-sm">
                                                    <i class="ace-icon fa fa-refresh"></i>
                                                    <span class="bigger-110">重置</span>
                                                </button>
                                                <button id="submit" type="submit" class="width-65 pull-right btn btn-sm btn-success">
                                                    <span class="bigger-110">注册</span>
                                                    <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="toolbar center">
                                    <a href="#" data-target="#login-box" class="back-to-login-link">
                                        <i class="ace-icon fa fa-arrow-left"></i> 返回登录
                                    </a>
                                </div>
                            </div>
                            <!-- /.widget-body -->
                        </div>
                        <!-- /.signup-box -->
                    </div>
                    <!-- /.position-relative -->

                    <div class="navbar-fixed-top align-right">
                        <br /> &nbsp;
                        <a id="btn-login-dark" href="#">Dark</a> &nbsp;
                        <span class="blue">/</span> &nbsp;
                        <a id="btn-login-blur" href="#">Blur</a>&nbsp;
                        <span class="blue">/</span> &nbsp;
                        <a id="btn-login-light" href="#">Light</a> &nbsp; &nbsp; &nbsp;
                    </div>
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.main-content -->
</div>
<!-- /.main-container -->

<!-- basic scripts -->
<!--[if !IE]> -->
<script src="${cps}/static/index/js/jquery.2.1.1.min.js"></script>
<script src="${cps}/static/index/js/bootstrap.min.js"></script>
<script src="${cps}/static/myjs/form.js"></script>
<!-- <![endif]-->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery
    || document
        .write("<script src='${cps}/static/index/js/jquery.min.js'>"
            + "<"+"/script>");
</script>
<!-- <![endif]-->

<script type="text/javascript">
    if ('ontouchstart' in document.documentElement)
        document
            .write("<script src='${cps}/static/index/js/jquery.mobile.custom.min.js'>"
                + "<"+"/script>");
</script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function($) {
        $(document).on('click', '.toolbar a[data-target]', function(e) {
            e.preventDefault();
            var target = $(this).data('target');
            $('.widget-box.visible').removeClass('visible');//hide others
            $(target).addClass('visible');//show target
        });
    });

    //you don't need this, just used for changing background
    jQuery(function($) {
        $('#btn-login-dark').on('click', function(e) {
            $('body').attr('class', 'login-layout');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-light').on('click', function(e) {
            $('body').attr('class', 'login-layout light-login');
            $('#id-text2').attr('class', 'grey');
            $('#id-company-text').attr('class', 'blue');

            e.preventDefault();
        });
        $('#btn-login-blur').on('click', function(e) {
            $('body').attr('class', 'login-layout blur-login');
            $('#id-text2').attr('class', 'white');
            $('#id-company-text').attr('class', 'light-blue');

            e.preventDefault();
        });
    });
</script>
<script>
    $(function () { $("[data-toggle='tooltip']").tooltip(); });
</script>
</body>
</html>
