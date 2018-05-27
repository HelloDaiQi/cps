<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/3
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>申请项目信息管理</title>
    <%@include file="public/headManage.jsp" %>
</head>
<body>
<fieldset class="layui-elem-field site-demo-button" style="margin-top: 10px; border: 0px">
    <div>
        <div class="reloadForm layui-form">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    &nbsp;
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
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 100px;">
                    <button class="searchBtn layui-btn" data-type="reload">查找申请项目</button>
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
    <a class="layui-btn layui-btn-xs" lay-event="detail">详细信息</a>
</script>

<script>
    layui.use(['layer', 'table', 'element', 'form'], function(){
        layer = layui.layer //弹层
            ,table = layui.table //表格
            ,element = layui.element //元素操作
            ,form=layui.form;

        if(${requestScope.message !=null}){
            layer.msg('${message}');
        }

        //执行一个 table 实例
        table.render({
            elem: '#test'
            ,id: 'aprojectReload'
            ,height: 420
            ,url: '${cps}/aproject/listAproject.do'
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'aprojectid', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'projectid', title: '项目ID', width:120, sort: true}
                ,{field: 'applicant', title: '申请人ID', width:120, sort: true}
                ,{field: 'reason', title: '申请理由', width:400}
                ,{field: 'result', title: '申请结果', width:200}
                ,{fixed: 'right', width: 180, align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                window.location.href='${cps}/aproject/editAproject.do?aprojectid='+data.aprojectid;
            }
        });

        var reloadActive = {
            reload:function () {
                var content = $('#content').val();
                var condition = $('#condition').val();
                //执行重载
                table.reload('aprojectReload',{
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
