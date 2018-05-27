<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/31
  Time: 11:43
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
    <link href="${cps}/static/selectMultiple/css/public.css" rel="stylesheet" media="all">
    <script src="${cps}/static/selectMultiple/layui/layui.js"></script>
</head>
<body>
<script>
    layui.use(['form', 'layedit', 'laydate', 'upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,upload = layui.upload;


        //选完文件后不自动上传
        upload.render({
            elem: '#test8'
            ,url: '${cps}/user/uploadUserImage.do'
            ,method:'post'
            ,data:{userid:'${user.userid}'}
            ,auto: false
            //,multiple: true
            ,bindAction: '#test9'
            ,done: function(res){
                layer.msg("上传成功！");
            }
            ,error: function(index, upload){
                layer.msg("上传失败！");
            }
        });
    });
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">管理员信息详情</legend>
</fieldset>

<form class="layui-form" action="${cps}/user/saveAdmin.do">
    <c:if test="${requestScope.user!=null}">
        <div class="layui-form-item">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <img src="/mysrc/${requestScope.user.userimage}" class="layui-nav-img" style="height: 100px;width: 100px">
            <div class="layui-upload">
                <button type="button" class="layui-btn layui-btn-normal" id="test8">选择图片</button>
                <button type="button" class="layui-btn" id="test9">上传头像</button>
            </div>
        </div>
    </c:if>
    <div class="layui-form-item">
        <label class="layui-form-label">用户昵称</label>
        <div class="layui-input-inline">
            <input name="nickname" value="${requestScope.user.nickname}" placeholder="请输入昵称" class="layui-input" type="text">
        </div>
        <div class="layui-input-inline">
            <input name="userid" value="${requestScope.user.userid}" placeholder="请输入ID" autocomplete="off" class="layui-input" type="hidden">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
            <div class="layui-input-inline">
                <input name="email" value="${requestScope.user.email}" placeholder="请输入邮箱" class="layui-input" type="text" readonly="readonly">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">管理员角色</label>
        <div class="layui-input-inline">
            <select lay-filter="roleids" multiple name="roleids" lay-verify="required">
                <option value="">请选择...</option>
                <c:forEach var="userRole" items="${userRoleList}">
                    <option value="${userRole.roleid}" selected="">${userRole.rolename}</option>
                </c:forEach>
                <c:forEach var="role" items="${roleList}">
                    <option value="${role.roleid}">${role.rolename}</option>
                </c:forEach>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
        </div>
    </div>
</form>
</body>
</html>
