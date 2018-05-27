<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/26
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>认证用户管理</title>
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css" media="all">
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    </style>
    <script src="${cps}/static/jquery/jquery-3.2.1.js"></script>
    <script src="${cps}/static/jquery/jquery-3.2.1.min.js"></script>
    <script src="${cps}/static/layui/layui.js"></script>
</head>

<body>
<fieldset class="layui-elem-field site-demo-button" style="margin-top: 10px; border: 0px">
    <div>
        <div class="reloadForm layui-form">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <button class="layui-btn" type="button" onclick="javascript:window.location.href='${cps}/project/editProject.do'">添加项目</button>
                </div>
                <div class="layui-input-inline" style="width: 350px">
                    &nbsp;
                </div>
                <div class="layui-input-inline">
                    <input id="content" name="content" lay-verify="title" autocomplete="off" placeholder="请输入查找信息" class="layui-input" type="text">
                </div>
                <div class="layui-input-inline" style="width: 100px">
                    <select id="condition" name="condition" lay-verify="required" lay-search="">
                        <option value="">查找条件...</option>
                        <option value="1">ID</option>
                        <option value="2">项目名</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 100px;">
                    <button class="searchBtn layui-btn" data-type="reload">查找项目</button>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<table class="layui-hide" id="test" lay-filter="demo"></table>
<%
    request.removeAttribute("message");//使用过后及时清空，防止反复弹出。
%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="status">改变状态</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑/查看</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['layer', 'table', 'element', 'form'], function(){
        layer = layui.layer //弹层
            ,table = layui.table //表格
            ,element = layui.element //元素操作
            ,form=layui.form;

        if(${message !=null}){
            layer.msg('${message}');
        }

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.msg('切换了：'+ this.innerHTML);
            console.log(data);
        });

        //执行一个 table 实例
        table.render({
            elem: '#test'
            ,id: 'projectReload'
            ,height: 420
            ,url: '${cps}/project/listProject.do' //数据接口 *****?page=1&limit=10
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'projectid', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'projectname', title: '项目名', width:120}
                ,{field: 'demand', title: '项目需求', width:270}
                ,{field: 'numbers', title: '需求人数', width:100, sort: true}
                ,{field: 'progress', title: '项目进度%', width: 100, sort: true}
                ,{field: 'introduction', title: '项目简介', width: 120}
                ,{field: 'status', title: '状态', width: 100, sort: true}
                ,{fixed: 'right', width: 220, align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'status'){
                $.ajax({
                    type: "POST",
                    async:true,
                    url: "${cps}/project/changeProjectStatus.do",
                    data: { projectid:data.projectid,status:data.status },
                    success: function (json) {
                        console.log(json);
                        if (json.json == "success") {
                            reloadActive['reload'].call(this);
                            layer.msg("success");
                        }else{
                            layer.msg("false");
                        }
                    }
                });
            } else if(layEvent === 'edit'){
                window.location.href='${cps}/project/editProject.do?projectid='+data.projectid;
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type: "POST",
                        async:true,
                        url: "${cps}/project/deleteProject.do",
                        data: { projectid:data.projectid},
                        success: function (json) {
                            console.log(json);
                            if (json.json == "success") {
                                reloadActive['reload'].call(this);
                                layer.msg("success");
                            }else{
                                layer.msg(json.json);
                            }
                        }
                    });
                });
            }
        });

        var reloadActive = {
            reload:function () {
                var content = $('#content').val();
                var condition = $('#condition').val();
                //执行重载
                table.reload('projectReload',{
                    page:{
                        curr:1//重新从第一页开始
                    }
                    ,where:{
                        content:content,
                        condition:condition
                    }
                });
            }
        };
        $('.reloadForm .searchBtn').on('click',function () {
            var type=$(this).data('type');
            reloadActive[type] ? reloadActive[type].call(this):'';
        });
    });
</script>
</body>
</html>
