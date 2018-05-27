<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/31
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>提示信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css"  media="all">
</head>
<body style="text-align:center">
<h2 style="margin-top: 30%">${message}</h2>

<script src="${cps}/static/layui/layui.js" charset="utf-8"></script>
</body>
</html>
