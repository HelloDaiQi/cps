<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/28
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css"  media="all">
    <script src="${cps}/static/layui/layui.js"></script>
</head>
<body>
<script>
    layui.use(['form', 'layer'], function(){
        var form = layui.form
            ,layer = layui.layer;

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
    <legend align="center">用户信息详情</legend>
</fieldset>

<form class="layui-form" action="${cps}/cuser/saveCuser.do">
    <div class="layui-form-item">
        <label class="layui-form-label">用户昵称</label>
        <div class="layui-input-inline">
            <input name="nickname" value="${user.nickname}" lay-verify="title" autocomplete="off" placeholder="请输入昵称" class="layui-input" readonly="readonly" type="text">
        </div>
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-inline">
            <input name="realname" value="${cuser.realname}" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" readonly="readonly" type="text">
        </div>
        <div class="layui-input-inline">
            <input name="cuserid" value="${cuser.cuserid}" placeholder="请输入ID" autocomplete="off" class="layui-input" readonly="readonly" type="hidden">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
            <div class="layui-input-inline">
                <input name="email" value="${user.email}" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input" readonly="readonly" type="email">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-inline">
                <input name="cardnumber" value="${cuser.cardnumber}" lay-verify="" placeholder="请输入身份证号" autocomplete="off" class="layui-input" readonly="readonly" type="text">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>
        <div class="layui-input-block">
            <c:choose>
                <c:when test="${user.gender=='男'}">
                    <input name="gender" value="男" title="男" checked="" type="radio">
                    <input name="gender" value="女" title="女" type="radio">
                </c:when>
                <c:otherwise>
                    <input name="gender" value="男" title="男" type="radio">
                    <input name="gender" value="女" title="女" checked="" type="radio">
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校</label>
            <div class="layui-input-inline">
                <select name="school" lay-verify="" lay-search="">
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
        <div class="layui-inline">
            <label class="layui-form-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级</label>
            <div class="layui-input-inline">
                <select name="grade" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="grade" items="${gradeList}">
                        <c:choose>
                            <c:when test="${grade.gradeid==user.grade}">
                                <option value="${grade.gradeid}" selected="">${grade.gradename}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${grade.gradeid}">${grade.gradename}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">认证理由</label>
        <div class="layui-input-block">
            <textarea name="introduction" placeholder="请输入内容"  class="layui-textarea">${cuser.reason}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">审核意见</label>
        <div class="layui-input-block">
            <input name="opinion" value="${cuser.opinion}" lay-verify="" autocomplete="off" placeholder="请输入意见" class="layui-input" type="text">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <c:if test="${cuser.status=='审核中'}">
                <button name="check" value="审核不通过" class="layui-btn layui-btn-danger" lay-submit="">审核不通过</button>
                <button name="check" value="审核通过" class="layui-btn" lay-submit="" lay-filter="demo1">审核通过</button>
            </c:if>
            <button type="button" class="layui-btn layui-btn-primary" onclick="javascript:history.back()">返回</button>
        </div>
    </div>
</form>
</body>
</html>
