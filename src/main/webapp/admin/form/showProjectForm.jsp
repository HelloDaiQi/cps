<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/6
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html>
<head>
    <meta charset="utf-8">
    <title>项目信息管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css"  media="all">
    <script src="${cps}/static/layui/layui.js"></script>
</head>
<body>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 2 || value.length>5){
                    return '昵称至少2个字符,至多5个字符';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,content: function(value){
                layedit.sync(editIndex);
            }
            ,numbers:function (value) {
                if(value<1){
                    return '人数至少是一人';
                }
            }
            ,progress:function (value) {
                if(value<0||value>100){
                    return '项目进度需在0%~100%之间';
                }
            }
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return true;
        });

    });
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">项目信息详情</legend>
</fieldset>

<form class="layui-form" action="#">
    <div class="layui-form-item">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="/mysrc/${project.projectimage}" class="layui-nav-img" style="height: 100px;width: 100px">
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">项目名称</label>
        <div class="layui-input-inline">
            <input name="projectname" value="${project.projectname}" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">项目组长</label>
            <div class="layui-input-inline">
                <select name="releaser" lay-verify="required" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="cUser" items="${cUserList}">
                        <c:choose>
                            <c:when test="${cUser.cuserid==project.releaser}">
                                <option value="${cUser.cuserid}" selected="">${cUser.realname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${cUser.cuserid}">${cUser.realname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">项目类型</label>
            <div class="layui-input-inline">
                <select name="projecttype" lay-verify="required" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="projectType" items="${projectTypeList}">
                        <c:choose>
                            <c:when test="${projectType.typeid==project.projecttype}">
                                <option value="${projectType.typeid}" selected="">${projectType.typename}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${projectType.typeid}">${projectType.typename}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">需求人数</label>
            <div class="layui-input-inline">
                <input name="numbers" value="${project.numbers}" lay-verify="number|numbers" placeholder="请输入需求人数" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">项目进度%</label>
            <div class="layui-input-inline">
                <input name="progress" value="${project.progress}" lay-verify="number|progress" placeholder="默认为0" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">项目需求</label>
        <div class="layui-input-block">
            <textarea name="demand" placeholder="请输入项目需求" class="layui-textarea">${project.demand}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">小组成员</label>
        <c:forEach var="user" items="${userList}">
            <div class="layui-input-inline">
                <input value="${user.nickname}" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
            </div>
        </c:forEach>
    </div>



    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介</label>
        <div class="layui-input-block">
            <textarea name="introduction" placeholder="请输入内容" class="layui-textarea">${project.introduction}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <%--<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>--%>
            <button type="button" class="layui-btn layui-btn-primary" onclick="javascript:history.back()">返回</button>
        </div>
    </div>
</form>
</body>
</html>
