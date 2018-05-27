<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/26
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<!DOCTYPE html>
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
    layui.use(['form', 'layedit', 'laydate', 'upload'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate
            ,upload = layui.upload;

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

        //选完文件后不自动上传
        upload.render({
            elem: '#test8'
            ,url: '${cps}/project/uploadProjectImage.do'
            ,method:'post'
            ,data:{projectid:'${project.projectid}'}
            ,auto: false
            //,multiple: true
            ,bindAction: '#test9'
            ,done: function(res){
                layer.msg("上传成功，请刷新！");
            }
            ,error: function(index, upload){
                layer.msg("上传失败！");
            }
        });
    });
</script>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend align="center">项目信息详情</legend>
</fieldset>

<form class="layui-form" action="${cps}/project/saveProject.do">
    <c:if test="${project!=null}">
        <div class="layui-form-item">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <img src="/mysrc/${project.projectimage}" class="layui-nav-img" style="height: 100px;width: 100px">
            <div class="layui-upload">
                <button type="button" class="layui-btn layui-btn-normal" id="test8">选择图片</button>
                <button type="button" class="layui-btn" id="test9">上传头像</button>
            </div>
        </div>
    </c:if>
    <div class="layui-form-item">
        <label class="layui-form-label">项目名称</label>
        <div class="layui-input-inline">
            <input name="projectname" value="${project.projectname}" lay-verify="title" autocomplete="off" placeholder="请输入名称" class="layui-input" type="text">
        </div>
        <div class="layui-input-inline">
            <input name="projectid" value="${project.projectid}" placeholder="请输入ID" autocomplete="off" class="layui-input" type="hidden">
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
                            <c:when test="${cUser.userid==project.releaser}">
                                <option value="${cUser.userid}" selected="">${cUser.realname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${cUser.userid}">${cUser.realname}</option>
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
        <%--<div class="layui-inline">
            <label class="layui-form-label">项目进度%</label>
            <div class="layui-input-inline">
                <input name="progress" value="${project.progress}" lay-verify="number|progress" placeholder="默认为0" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>--%>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">项目进度</label>
        <div class="layui-input-block">
        <c:choose>
            <c:when test="${project.progress == 0}">
                <input type="checkbox" name="progresses" value="0" title="开始" checked="" disabled="">
                <input type="checkbox" name="progresses" value="20" title="需求分析">
                <input type="checkbox" name="progresses" value="40" title="项目启动">
                <input type="checkbox" name="progresses" value="60" title="项目计划">
                <input type="checkbox" name="progresses" value="80" title="项目实施">
                <input type="checkbox" name="progresses" value="100" title="结束">
            </c:when>
            <c:when test="${project.progress == 20}">
                <input type="checkbox" name="progresses" value="0" title="开始" checked="" disabled="">
                <input type="checkbox" name="progresses" value="20" title="需求分析" checked="" disabled="">
                <input type="checkbox" name="progresses" value="40" title="项目启动">
                <input type="checkbox" name="progresses" value="60" title="项目计划">
                <input type="checkbox" name="progresses" value="80" title="项目实施">
                <input type="checkbox" name="progresses" value="100" title="结束">
            </c:when>
            <c:when test="${project.progress == 40}">
                <input type="checkbox" name="progresses" value="0" title="开始" checked="" disabled="">
                <input type="checkbox" name="progresses" value="20" title="需求分析" checked="" disabled="">
                <input type="checkbox" name="progresses" value="40" title="项目启动" checked="" disabled="">
                <input type="checkbox" name="progresses" value="60" title="项目计划">
                <input type="checkbox" name="progresses" value="80" title="项目实施">
                <input type="checkbox" name="progresses" value="100" title="结束">
            </c:when>
            <c:when test="${project.progress == 60}">
                <input type="checkbox" name="progresses" value="0" title="开始" checked="" disabled="">
                <input type="checkbox" name="progresses" value="20" title="需求分析" checked="" disabled="">
                <input type="checkbox" name="progresses" value="40" title="项目启动" checked="" disabled="">
                <input type="checkbox" name="progresses" value="60" title="项目计划" checked="" disabled="">
                <input type="checkbox" name="progresses" value="80" title="项目实施">
                <input type="checkbox" name="progresses" value="100" title="结束">
            </c:when>
            <c:when test="${project.progress == 80}">
                <input type="checkbox" name="progresses" value="0" title="开始" checked="" disabled="">
                <input type="checkbox" name="progresses" value="20" title="需求分析" checked="" disabled="">
                <input type="checkbox" name="progresses" value="40" title="项目启动" checked="" disabled="">
                <input type="checkbox" name="progresses" value="60" title="项目计划" checked="" disabled="">
                <input type="checkbox" name="progresses" value="80" title="项目实施" checked="" disabled="">
                <input type="checkbox" name="progresses" value="100" title="结束">
            </c:when>
            <c:when test="${project.progress == 100}">
                <input type="checkbox" name="progresses" value="0" title="开始" checked="" disabled="">
                <input type="checkbox" name="progresses" value="20" title="需求分析" checked="" disabled="">
                <input type="checkbox" name="progresses" value="40" title="项目启动" checked="" disabled="">
                <input type="checkbox" name="progresses" value="60" title="项目计划" checked="" disabled="">
                <input type="checkbox" name="progresses" value="80" title="项目实施" checked="" disabled="">
                <input type="checkbox" name="progresses" value="100" title="结束" checked="" disabled="">
            </c:when>
            <c:otherwise>
                <input type="checkbox" name="progresses" value="0" title="开始">
                <input type="checkbox" name="progresses" value="20" title="需求分析">
                <input type="checkbox" name="progresses" value="40" title="项目启动">
                <input type="checkbox" name="progresses" value="60" title="项目计划">
                <input type="checkbox" name="progresses" value="80" title="项目实施">
                <input type="checkbox" name="progresses" value="100" title="结束">
            </c:otherwise>
        </c:choose>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">项目需求</label>
        <div class="layui-input-block">
            <textarea name="demand" maxlength="100" placeholder="请输入项目需求(0~100个字符之间)" class="layui-textarea">${project.demand}</textarea>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介</label>
        <div class="layui-input-block">
            <textarea name="introduction" maxlength="100" placeholder="请输入内容(0~100个字符之间)" class="layui-textarea">${project.introduction}</textarea>
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
