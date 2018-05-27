<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/9
  Time: 10:27
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
    <title>我的参加信息</title>
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
<script>

    /*------------------------------------------*/
    window.operateEvents = {
        'click .RoleOfedit': function (e, value, row, index) {
            var projectimage=row.projectExtends.projectimage;
            var projectname=row.projectExtends.projectname;
            var typename=row.projectExtends.type.typename;
            var release=row.projectExtends.userExtends.nickname;
            var numbers=row.projectExtends.numbers;
            var progress=row.projectExtends.progress;
            var demand=row.projectExtends.demand;
            var introduction=row.projectExtends.introduction;
            var projectMumberExtensList=row.projectExtends.projectMumberExtensList;
            var tmp="";
            for(i=0;i<projectMumberExtensList.length;i++){
                tmp+="<td>"+"小组成员"+"</td><td>"+projectMumberExtensList[i].userExtends.nickname+"</td>";
            }
            var content1='<table class="table table-bordered">\n' +
                '    <tbody>\n' +
                '    <tr>\n' +
                '        <td>图片介绍\n' +
                '            <div id="imgDiv">\n' +
                '                <img id="img" style="width: 80px;" src="${cps}/mysrc/'+projectimage+'">\n' +
                '            </div>\n' +
                '        </td>\n' +
                '        <td></td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>项目名称</td>\n' +
                '        <td>'+projectname+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>项目类型</td>\n' +
                '        <td>'+typename+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>项目组长</td>\n' +
                '        <td>'+release+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>需求人数</td>\n' +
                '        <td>'+numbers+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>项目需求</td>\n' +
                '        <td>'+demand+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>项目介绍</td>\n' +
                '        <td>'+introduction+'</td>\n' +
                '    </tr>\n';
            var content2='</tbody>\n' +
                '       </table>';
            $("#myModal").find('.modal-body').html(content1+tmp+content2);
            $("#myModal").modal('show');
        },
    };
    function operateFormatter(value, row, index) {
        return [
            '<div class="row">' +
            '<div class="form-inline">' +
            '<input type="button" value="查看" class="RoleOfedit btn btn-primary btn-sm"  data-toggle="modal" style="display:inline">' +
            '</div>' +
            '<div>',
        ].join('');
    }
</script>
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
                <li><a style="background-color: #deded4"
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
            <table id="aprojectTable" class="table table-hover table-bordered" style="margin-top: 20px">
            </table>
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
<script src="${cps}/static/index/js/bootstrap-table.js"></script>
<script src="${cps}/static/index/js/jquery.easing.min.js"></script>
<script src="${cps}/static/index/js/jquery.scrollTo.js"></script>
<script src="${cps}/static/index/js/wow.min.js"></script>
<script type="text/javascript">
    $("#aprojectTable").bootstrapTable({
        url:'${cps}/project/jprojectInfoList.do',
        //是否显示查找
        search: false,
        //是否分页
        pagination: true,
        //每页显示多少条数据，也就是要显示多少行
        pageSize: 10,
        //分页，选择不同数字会改变上面的pageSize
        pageList: [5, 10, 15, 20],
        //显示列
        showColumns: false,
        //显示刷新按钮
        showRefresh: false,
        //是否可见
        showToggle: false,
        //默认英文，设置如下就是显示中文
        locale: "zh-CN",
        //显示时background-color白灰相间
        striped: true,
        columns:[
            {title:'序号',field:'projectmumberid'},
            {title:'项目名称',field:'projectname',
                formatter:function(value,row,index){
                    return row.projectExtends.projectname;
                }
            },
            {title:'项目组长',field:'nickname',
                formatter:function(value,row,index){
                    return row.projectExtends.userExtends.nickname;
                }
            },
            {title:'项目状态',field:'status',
                formatter:function(value,row,index){
                    return row.projectExtends.status;
                }
            },
            {field: 'operate',title: '操作',
                width: '80px',
                events: operateEvents,
                formatter: operateFormatter
            }
        ],
    });

    /*-----------------------------*/
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
