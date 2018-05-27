<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/2
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>熟练度信息详情</title>
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
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return true;
        });
    });
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">熟练度信息详情</legend>
</fieldset>

<form class="layui-form" action="${cps}/proficiency/saveProficiency.do">
    <div class="layui-form-item">
        <label class="layui-form-label">熟练度名称</label>
        <div class="layui-input-inline">
            <input name="proficiencyname" value="${proficiency.proficiencyname}" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
        </div>
        <div class="layui-input-inline">
            <input name="proficiencyid" value="${proficiency.proficiencyid}" placeholder="请输入ID" autocomplete="off" class="layui-input" type="hidden">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">熟练度简介</label>
        <div class="layui-input-block">
            <textarea name="introduction" placeholder="请输入内容"  class="layui-textarea">${proficiency.introduction}</textarea>
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
