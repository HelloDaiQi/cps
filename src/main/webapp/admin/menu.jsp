<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/6
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>校园合伙人系统后台管理系统</title>
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${cps}/static/build/css/font-awesome.min.css">
    <link rel="stylesheet" href="${cps}/static/build/css/app.css" media="all">
    <script src="${cps}/static/layui/layui.js"></script>
</head>
<script type="text/javascript">
    var message;
    layui.config({
        base: '${cps}/static/build/js/'
    }).use(['app','layer', 'message'], function() {
        var app = layui.app,
            $ = layui.jquery,
            layer = layui.layer;
        //将message设置为全局以便子页面调用
        message = layui.message;
        //主入口
        app.set({
            type: 'iframe'
        }).init();


        //捐赠我
        $('#pay').on('click', function() {
            layer.open({
                title: false,
                type: 1,
                content: '<img src="${cps}/static/build/images/pay.jpg" />',
                area: ['430px', '310px'],
                shadeClose: true
            });
        });

        //管理员信息
        $('#adminInfo').on('click',function () {
            layer.open({
                type: 2 //此处以iframe举例
                ,title: '管理员信息'
                ,area: ['500px', '600px']
                ,shade: 0
                ,maxmin: true
                ,content: '${cps}/user/editAdmin.do'
                ,btn: ['关闭']
                ,yes: function(){
                    layer.closeAll();
                }
                // ,zIndex: layer.zIndex //重点1
                // ,success: function(layero){
                //     layer.setTop(layero); //重点2
                // }
            });
        });

        //管理员信息
        $('#adminPassword').on('click',function () {
            layer.open({
                type: 2
                ,title: '管理员密码'
                ,area: ['500px', '300px']
                ,shade: 0
                ,maxmin: true
                ,content: '${cps}/user/updateAdminPasswordForm.do'
                ,btn: ['关闭']
                ,yes: function(){
                    layer.closeAll();
                }
            });
        });

        //退出
        $('#logout').on('click', function() {
            layer.msg('您确定退出吗？', {
                time: 20000 //20s后自动关闭
                ,btn: ['Yes', 'No']
                ,yes: function(){
                    window.location.href="${cps}/logout.do";
                }
                ,no: function(){
                    layer.closeAll();
                }
            });
        });

        // //示范一个公告层
        // layer.open({
        //     type: 1
        //     ,title: false //不显示标题栏
        //     ,closeBtn: false
        //     ,area: '300px;'
        //     ,shade: 0.8
        //     ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
        //     ,btn: ['火速围观', '残忍拒绝']
        //     ,btnAlign: 'c'
        //     ,moveType: 1 //拖拽模式，0或者1
        //     ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
        //     ,success: function(layero){
        //         var btn = layero.find('.layui-layer-btn');
        //         btn.find('.layui-layer-btn0').attr({
        //             href: 'http://www.layui.com/'
        //             ,target: '_blank'
        //         });
        //     }
        // });
    });
</script>

<script></script>

<body>
<div class="layui-layout layui-layout-admin kit-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">后台管理系统</div>
        <div class="layui-logo kit-logo-mobile">K</div>
        <%--<ul class="layui-nav layui-layout-left kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">控制台</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" id="pay"><i class="fa fa-gratipay" aria-hidden="true"></i> 捐赠我</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;">消息管理</a>
                    </dd>
                    <dd>
                        <a href="javascript:;">授权管理</a>
                    </dd>
                </dl>
            </li>
        </ul>--%>
        <ul class="layui-nav layui-layout-right kit-nav">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${cps}/mysrc/${sessionScope.user.userimage}" class="layui-nav-img"> ${sessionScope.user.email}
                </a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" id="adminInfo">基本资料</a>
                    </dd>
                    <dd>
                        <a href="javascript:;" id="adminPassword">安全设置</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" id="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>注销</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black kit-side">
        <div class="layui-side-scroll">
            <div class="kit-side-fold"><i class="fa fa-navicon" aria-hidden="true"></i></div>
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="kitNavbar" kit-navbar>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>用戶管理</span>
                    <c:if test="${userBage >0 || cuserBage >0}">
                        <span class="layui-badge-dot"></span>
                    </c:if>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'userManage.jsp',icon:'fa-user',title:'user',id:'1'}">
                                <i class="layui-icon">&#xe770;</i><span>普通用户管理</span>
                                <c:if test="${userBage >0 }">
                                    <span class="layui-badge">新增userBage</span>
                                </c:if>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'cuserManage.jsp',icon:'fa-user',title:'cuser',id:'2'}">
                                <i class="fa fa-user" aria-hidden="true"></i><span>认证用户管理</span>
                                <c:if test="${cuserBage >0 }">
                                    <span class="layui-badge">新增cuserBage</span>
                                </c:if>
                            </a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>项目管理</span>
                        <c:if test="${projectBage >0}">
                            <span class="layui-badge-dot"></span>
                        </c:if>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'projectManage.jsp',icon:'&#xe658;',title:'project',id:'3'}">
                                <i class="layui-icon">&#xe60a;</i><span>项目信息管理</span>
                                <c:if test="${projectBage >0}">
                                    <span class="layui-badge">新增projectBage</span>
                                </c:if>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'aprojectManage.jsp',icon:'&#xe658;',title:'aproject',id:'4'}">
                                <i class="layui-icon">&#xe63c;</i><span>申请项目管理</span></a>
                        </dd>
                        <%--<dd>
                            <a href="javascript:;" kit-target data-options="{url:'showProjectManage.jsp',icon:'&#xe658;',title:'showProject',id:'5'}">
                                <i class="layui-icon">&#xe658;</i><span>展示项目管理</span></a>
                        </dd>--%>
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'projectTypeManage.jsp',icon:'&#xe658;',title:'projectType',id:'6'}">
                                <i class="layui-icon">&#xe63c;</i><span>项目类型管理</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>学校管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'schoolManage.jsp',icon:'&#xe614;',title:'school',id:'7'}">
                                <i class="layui-icon">&#xe705;</i><span>学校信息管理</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'gradeManage.jsp',icon:'&#xe658;',title:'grade',id:'8'}">
                                <i class="layui-icon">&#xe705;</i><span>年级信息管理</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'professionalManage.jsp',icon:'&#xe658;',title:'professional',id:'9'}">
                                <i class="layui-icon">&#xe705;</i><span>专业信息管理</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>技能管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'skillManage.jsp',icon:'&#xe658;',title:'skill',id:'10'}">
                                <i class="layui-icon">&#xe653;</i><span>技能信息管理</span></a>
                        </dd>
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'proficiencyManage.jsp',icon:'&#xe658;',title:'proficiency',id:'11'}">
                                <i class="layui-icon">&#xe653;</i><span>熟&nbsp;练&nbsp;度&nbsp;管&nbsp;理</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>信息管理</span>
                        <c:if test="${feedbackBage > 0}">
                            <span class="layui-badge-dot"></span>
                        </c:if>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'feedbackManage.jsp',icon:'&#xe658;',title:'feedback',id:'12'}">
                                <i class="layui-icon">&#xe667;</i><span>反馈信息管理</span>
                            <c:if test="${feedbackBage > 0}">
                                <span class="layui-badge-dot"></span>
                            </c:if>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'messageManage.jsp',icon:'&#xe658;',title:'message',id:'13'}">
                                <i class="layui-icon">&#xe667;</i><span>私信信息管理</span></a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;"><i class="fa fa-plug" aria-hidden="true"></i><span>扩展管理</span></a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;" kit-target data-options="{url:'roleManage.jsp',icon:'&#xe658;',title:'role',id:'14'}">
                                <i class="layui-icon">&#xe770;</i><span>角色信息管理</span></a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body" id="container">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">主体内容加载中,请稍等...</div>
    </div>

    <div class="layui-footer" align="center">
        <!-- 底部固定区域 -->
        Copyright © 2017-2018 DaiQi 版权所有
    </div>
</div>

</body>
</html>
