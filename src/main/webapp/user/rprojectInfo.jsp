<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/8
  Time: 10:39
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
    <title>发布项目列表</title>
    <link href="${cps}/static/index/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/animate.css" rel="stylesheet"/>
    <link href="${cps}/static/index/css/style.css" rel="stylesheet">
    <link href="${cps}/static/index/css/default.css" rel="stylesheet">
    <link href="${cps}/static/index/css/toastr/toastr.min.css" rel="stylesheet">
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
            var projectimage=row.projectimage;
            var projectname=row.projectname;
            var typename=row.type.typename;
            var demand=row.demand;
            var demand1="";
            var demand2="";
            var demand3="";
            if(demand.length>33 && demand.length<=66){
                demand1+=demand.substring(0,33);
                demand2+=demand.substring(34,demand.length);
            }else if(demand.length>66){
                demand1+=demand.substring(0,33);
                demand2+=demand.substring(34,66);
                demand3+=demand.substring(67,demand.length-1);
            }
            else {
                demand1+=demand;
            }
            var introduction=row.introduction;
            var introduction1="";
            var introduction2="";
            var introduction3="";
            if(introduction.length>33 && introduction.length<=66){
                introduction1+=introduction.substring(0,33);
                introduction2+=introduction.substring(34,introduction.length);
            }else if(introduction.length>66){
                introduction1+=introduction.substring(0,33);
                introduction2+=introduction.substring(34,66);
                introduction3+=introduction.substring(67,introduction.length-1);
            }
            else {
                introduction1+=introduction;
            }
            var numbers=row.numbers;
            var progress=row.progress;
            var projectMumberExtensList=row.projectMumberExtensList;
            var applicationProjectExtendsList=row.applicationProjectExtendsList;
            var tmp1="";
            for(var i=0;i<projectMumberExtensList.length;i++){
                tmp1+="<tr>";
                tmp1+="<td>小组成员</td><td>"+projectMumberExtensList[i].userExtends.nickname+"</td>";
                tmp1+="</tr>";
            }
            var tmp2="";
            for(var i=0;i<applicationProjectExtendsList.length;i++){
                tmp2+="<tr>";
                tmp2+="<td>申请成员</td>";
                tmp2+="<td>"+applicationProjectExtendsList[i].userExtends.nickname+"</td>";
                tmp2+="<td>";
                var reason = applicationProjectExtendsList[i].reason;
                var reason1="";
                if(reason.length>33 && reason.length<=66){
                    reason1+=reason.substring(0,33);
                    reason1+='<br>'+reason.substring(34,reason.length-1);
                }else if(reason.length>66){
                    reason1+=reason.substring(0,33);
                    reason1+='<br>'+reason.substring(34,66);
                    reason1+='<br>'+reason.substring(67,reason.length-1);
                }else {
                    reason1+=reason;
                }
                tmp2+=reason1;
                tmp2+="</td>";
                tmp2+="<td>\n" +
                    "        <div class=\"container\">\n" +
                    "        \t<button type=\"button\" onclick=\"allow("+applicationProjectExtendsList[i].aprojectid+",'allow')\" class=\"btn\">允许</button>\n" +
                    "        \t<button type=\"button\" onclick=\"deny("+applicationProjectExtendsList[i].aprojectid+",'deny')\" class=\"btn btn-danger\">拒绝</button>\n" +
                    "        </div>\n" +
                    "        </td>";
                tmp2+="</tr>";
            }
            var content1='<table id="detail1" style="width: 100%; white-space: nowrap;" class="table table-bordered">\n' +
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
                '        <td>项目需求</td>\n' +
                '        <td>'+demand1+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td></td>\n' +
                '        <td>'+demand2+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td></td>\n' +
                '        <td>'+demand3+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>项目介绍</td>\n' +
                '        <td>'+introduction1+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td></td>\n' +
                '        <td>'+introduction2+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td></td>\n' +
                '        <td>'+introduction3+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>需要人数</td>\n' +
                '        <td>'+numbers+'</td>\n' +
                '    </tr>\n' +
                '    <tr>\n' +
                '        <td>项目进度</td>\n' +
                '        <td>'+progress+'%</td>\n' +
                '    </tr>\n';
            var content2='<table id="detail2" style="width: 100%; white-space: nowrap;" class="table table-bordered">\n' +
                '    <tbody>\n';
            var content3='</tbody>\n' +
                    '</table>';
            $("#myModal").find('.modal-body').html(content1+tmp1+content3+content2+tmp2+content3);
            //document.getElementById("detail").innerHTML="<tr>"+tmp+"</tr>";
            $("#myModal").modal('show');
        },
        'click .RoleOfupdate': function (e, value, row, index) {
            window.location.href="${cps}/project/updateRprojectInfo.do?projectid="+row.projectid;
        },
        'click .RoleOfdelete': function (e, value, row, index) {
            var projectid = row.projectid;
            //var result=confirm("aaa");
            Ewin.confirm({message: "确认要删除选择的数据吗？"}).on(function (e) {
                if (!e) {
                    return;
                }
                $.ajax({
                    type: "post",
                    url: "${cps}/project/deleteProject.do",
                    data: { "projectid": projectid },
                    success: function (data, status) {
                        console.log(data);
                        console.log(status);
                        if (status == "success" && data.json=="ture") {
                            toastr.success('删除成功！');
                            $("#messageTable").bootstrapTable('refresh');
                        }else{
                            toastr.success('删除失败，请确认无人申请项目且无项目成员！');
                        }
                    },
                    error: function () {
                        toastr.error('Error');
                    },
                    complete: function () {

                    }
                });
            });
        },
    };
    function operateFormatter(value, row, index) {
        return [
            '<div class="row">' +
            '<div class="form-inline">' +
            '<input type="button" value="查看" class="RoleOfedit btn btn-primary btn-sm"  data-toggle="modal" style="display:inline">' +
            '<input type="button" value="修改" class="RoleOfupdate btn btn-success btn-sm"  data-toggle="modal" style="display:inline">' +
            '<input type="button" value="删除" class="RoleOfdelete btn btn-danger btn-sm"  data-toggle="modal" style="display:inline">' +
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
                <li><a style="background-color: #deded4"
                        href="${cps}/project/rprojectInfo.do">发布项目信息
                    <c:if test="${RprojectInfoBadge > 0}">
                        <span class="badge" style="color : red;">!</span>
                    </c:if>
                    </a></li>
                <%--<li><a style=""
                       href="${cps}/project/rprojectInfo.do">发布项目(完成)</a></li>--%>
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

        <div class="col-md-10">
            <table id="projectTable" class="table table-hover table-bordered" style="margin-top: 20px">
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
<script src="${cps}/static/index/js/toastr/toastr.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        if(${result!=null and result>0}){
            toastr.success('修改成功！');
        }else if(${result!=null and result<=0}){
            toastr.success('修改失败！');
        }
    });

    $("#projectTable").bootstrapTable({
        url:'${cps}/project/rprojectInfoList.do',
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
            {title:'序号',field:'projectid'},
            {title:'项目名称',field:'projectname'},
            {title:'项目类型',field:'type',
                formatter:function(value,row,index){
                    return value.typename;
                }
            },
            {title:'需要人数',field:'numbers'},
            {title:'状态',field:'status'},
            {field: 'operate',title: '操作',
                width: '120px',
                events: operateEvents,
                formatter: operateFormatter
            }
        ],
    });

    function allow(value,type)
    {
        $.ajax({
            type: "post",
            url: "${cps}/aproject/checkUser.do",
            data: { "aprojectid": value,"type":type },
            success: function (data) {
                if (data.json == "success") {
                    toastr.success('成功！');
                    $("#myModal").modal('hide');
                    $("#projectTable").bootstrapTable('refresh');
                }else {
                    toastr.error("失败！");
                }
            },
            error: function () {
                toastr.error('Error');
            },
            complete: function () {

            }
        });
    }
    function deny(value,type)
    {
        $.ajax({
            type: "post",
            url: "${cps}/aproject/checkUser.do",
            data: { "aprojectid": value,"type":type },
            success: function (data) {
                if (data.json == "success") {
                    toastr.success('成功！');
                    $("#myModal").modal('hide');
                    $("#projectTable").bootstrapTable('refresh');
                }else {
                    toastr.error("失败！");
                }
            },
            error: function () {
                toastr.error('Error');
            },
            complete: function () {

            }
        });
    }

    /*--------------------------------------------*/
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

    /*=====================询问框========================*/
    (function ($) {
        window.Ewin = function () {
            var html = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
                '<div class="modal-dialog modal-sm">' +
                '<div class="modal-content">' +
                '<div class="modal-header">' +
                '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' +
                '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
                '</div>' +
                '<div class="modal-body">' +
                '<p>[Message]</p>' +
                '</div>' +
                '<div class="modal-footer">' +
                '<button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>' +
                '<button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';


            var dialogdHtml = '<div id="[Id]" class="modal fade" role="dialog" aria-labelledby="modalLabel">' +
                '<div class="modal-dialog">' +
                '<div class="modal-content">' +
                '<div class="modal-header">' +
                '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' +
                '<h4 class="modal-title" id="modalLabel">[Title]</h4>' +
                '</div>' +
                '<div class="modal-body">' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
            var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm');
            var generateId = function () {
                var date = new Date();
                return 'mdl' + date.valueOf();
            }
            var init = function (options) {
                options = $.extend({}, {
                    title: "操作提示",
                    message: "提示内容",
                    btnok: "确定",
                    btncl: "取消",
                    width: 200,
                    auto: false
                }, options || {});
                var modalId = generateId();
                var content = html.replace(reg, function (node, key) {
                    return {
                        Id: modalId,
                        Title: options.title,
                        Message: options.message,
                        BtnOk: options.btnok,
                        BtnCancel: options.btncl
                    }[key];
                });
                $('body').append(content);
                $('#' + modalId).modal({
                    width: options.width,
                    backdrop: 'static'
                });
                $('#' + modalId).on('hide.bs.modal', function (e) {
                    $('body').find('#' + modalId).remove();
                });
                return modalId;
            }

            return {
                alert: function (options) {
                    if (typeof options == 'string') {
                        options = {
                            message: options
                        };
                    }
                    var id = init(options);
                    var modal = $('#' + id);
                    modal.find('.ok').removeClass('btn-success').addClass('btn-primary');
                    modal.find('.cancel').hide();

                    return {
                        id: id,
                        on: function (callback) {
                            if (callback && callback instanceof Function) {
                                modal.find('.ok').click(function () { callback(true); });
                            }
                        },
                        hide: function (callback) {
                            if (callback && callback instanceof Function) {
                                modal.on('hide.bs.modal', function (e) {
                                    callback(e);
                                });
                            }
                        }
                    };
                },
                confirm: function (options) {
                    var id = init(options);
                    var modal = $('#' + id);
                    modal.find('.ok').removeClass('btn-primary').addClass('btn-success');
                    modal.find('.cancel').show();
                    return {
                        id: id,
                        on: function (callback) {
                            if (callback && callback instanceof Function) {
                                modal.find('.ok').click(function () { callback(true); });
                                modal.find('.cancel').click(function () { callback(false); });
                            }
                        },
                        hide: function (callback) {
                            if (callback && callback instanceof Function) {
                                modal.on('hide.bs.modal', function (e) {
                                    callback(e);
                                });
                            }
                        }
                    };
                },
                dialog: function (options) {
                    options = $.extend({}, {
                        title: 'title',
                        url: '',
                        width: 800,
                        height: 550,
                        onReady: function () { },
                        onShown: function (e) { }
                    }, options || {});
                    var modalId = generateId();

                    var content = dialogdHtml.replace(reg, function (node, key) {
                        return {
                            Id: modalId,
                            Title: options.title
                        }[key];
                    });
                    $('body').append(content);
                    var target = $('#' + modalId);
                    target.find('.modal-body').load(options.url);
                    if (options.onReady())
                        options.onReady.call(target);
                    target.modal();
                    target.on('shown.bs.modal', function (e) {
                        if (options.onReady(e))
                            options.onReady.call(target, e);
                    });
                    target.on('hide.bs.modal', function (e) {
                        $('body').find(target).remove();
                    });
                }
            }
        }();
    })(jQuery);
</script>
</body>
</html>
