<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/2
  Time: 15:58
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
<script>
    layui.use(['form', 'layedit'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit;

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.confirm(JSON.stringify(data.field));
        });
    });
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">反馈信息详情</legend>
</fieldset>

<form class="layui-form" action="${cps}/feedback/saveFeedback.do">
    <div class="layui-form-item">
        <label class="layui-form-label">反馈时间</label>
        <div class="layui-input-inline">
            <input name="nickname" value="${feedback.feedbacktime}" lay-verify="title" autocomplete="off" placeholder="请输入时间" class="layui-input" type="text">
        </div>
        <div class="layui-input-inline">
            <input name="feedbackid" value="${feedback.feedbackid}" placeholder="请输入ID" autocomplete="off" class="layui-input" type="hidden">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">反馈人</label>
        <div class="layui-input-inline">
            <input name="feedbackname" value="${user.nickname}" autocomplete="off" placeholder="请输入姓名" class="layui-input" type="text">
        </div>
        <label class="layui-form-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校</label>
        <div class="layui-inline">
            <div class="layui-input-inline">
                <select name="school" lay-verify="required" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="school" items="${schoolList}">
                        <c:choose>
                            <c:when test="${school.schoolid==user.school}">
                                <option value="${school.schoolid}" selected="">${school.schoolname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${school.schoolid}">${school.schoolname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">反馈简介</label>
        <div class="layui-input-block">
            <textarea name="introduction" placeholder="请输入内容"  class="layui-textarea">${feedback.content}</textarea>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">处理结果</label>
        <div class="layui-input-block">
            <textarea name="introduction" placeholder="请输入内容"  class="layui-textarea">${feedback.result}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="button" class="layui-btn layui-btn-primary" onclick="javascript:history.back()">返回</button>
        </div>
    </div>
</form>
</body>
</html>
