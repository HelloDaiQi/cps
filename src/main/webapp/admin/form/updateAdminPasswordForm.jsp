<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/31
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html>
<head>
    <meta charset="utf-8">
    <title>管理员信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css"  media="all">
    <script src="${cps}/static/layui/layui.js"></script>
</head>
<body>
<script>
    layui.use(['form', 'layedit', 'laydate', 'upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit;

        //自定义验证规则
        form.verify({
            repassword: function(value){
                var passwordObject = document.getElementById("password");
                var password = passwordObject.value;
                if(value != password){
                    return '两次密码必须一致！';
                }
            }
        });
    });
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">修改密码</legend>
</fieldset>

<form class="layui-form" action="${cps}/user/updateAdminPassword.do">
    <div class="layui-form-item">
        <div class="layui-input-inline">
            <input name="userid" value="${requestScope.user.userid}" placeholder="请输入ID" autocomplete="off" class="layui-input" type="hidden">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">新的密码</label>
            <div class="layui-input-inline">
                <input id="password" name="password" value="" placeholder="请输入新密码" class="layui-input" type="password">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">确认密码</label>
            <div class="layui-input-inline">
                <input id="repassword" name="repassword" value="" lay-verify="repassword" placeholder="请再次输入密码" class="layui-input" type="password">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">确认修改</button>
        </div>
    </div>
</form>
</body>
</html>