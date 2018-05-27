<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/3
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%--这个地方的css引入和网上的不太一样，不过效果大致实现了，先用着，有时间再弄--%>
    <link href="${cps}/static/index/css/admin.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/buttons.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${cps}/static/index/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="${cps}/static/index/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cps}/static/index/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<!--结果对话框-->
<div class="modal fade" id="resultModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示信息</h4>
            </div>
            <div class="modal-body">
                <h4 class="text-danger">${message}</h4>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="url" />
                <button type="button" class="btn btn-primary" data-dismiss="modal"
                        onclick="ok('${cps}/loginIndex.jsp')">确定</button>
            </div>
        </div>
    </div>
</div>
<script>
    $('#resultModal').modal();
    function ok(href) {
        location.replace(href);
    }
</script>
</body>
</html>
