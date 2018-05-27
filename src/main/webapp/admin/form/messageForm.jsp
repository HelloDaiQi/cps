<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/6
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>反馈信息详情</title>
    <%@include file="../public/headForm.jsp" %>
</head>
<body>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">反馈信息详情</legend>
</fieldset>

<form class="layui-form" action="#">
    <div class="layui-form-item">
        <label class="layui-form-label">发送人ID</label>
        <div class="layui-input-inline">
            <input value="${sender.userid}" readonly="readonly" autocomplete="off" class="layui-input" type="text">
        </div>
        <label class="layui-form-label">发送人</label>
        <div class="layui-input-inline">
            <input value="${sender.nickname}" readonly="readonly" autocomplete="off" class="layui-input" type="text">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">收信人ID</label>
        <div class="layui-input-inline">
            <input value="${receiver.userid}" readonly="readonly" autocomplete="off" class="layui-input" type="text">
        </div>
        <label class="layui-form-label">收信人</label>
        <div class="layui-input-inline">
            <input value="${receiver.nickname}" readonly="readonly" autocomplete="off" class="layui-input" type="text">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">发送时间</label>
        <div class="layui-input-inline">
            <input value="${message.sendtime}" autocomplete="off" class="layui-input" type="text">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">信息内容</label>
        <div class="layui-input-block">
            <textarea name="introduction" class="layui-textarea">${message.content}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="button" class="layui-btn layui-btn-primary" onclick="javascript:history.back()">返回</button>
        </div>
    </div>
</form>
</body>
</html>