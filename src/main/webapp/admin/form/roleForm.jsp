<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/30
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>角色信息详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css" media="all" />
    <link href="${cps}/static/selectMultiple/css/public.css" rel="stylesheet" media="all">
</head>
<body class="childrenBody">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">学校信息详情</legend>
</fieldset>

<form class="layui-form" action="${cps}/role/saveRole.do">
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-inline">
            <input name="rolename" value="${role.rolename}" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
        </div>
        <div class="layui-input-inline">
            <input name="roleid" value="${role.roleid}" placeholder="请输入ID" autocomplete="off" class="layui-input" type="hidden">
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="button" class="layui-btn layui-btn-primary" onclick="javascript:history.back()">返回</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${cps}/static/selectMultiple/layui/layui.js"></script>
<script type="text/javascript" src="${cps}/static/selectMultiple/selectMultiple.js"></script>
</body>
</html>
