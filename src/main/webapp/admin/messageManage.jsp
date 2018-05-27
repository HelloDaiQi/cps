<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/6
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>私信信息管理</title>
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
                        <option value="2">私信内容</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 100px;">
                    <button class="searchBtn layui-btn" data-type="reload">查找私信</button>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<table class="layui-hide" id="test" lay-filter="demo"></table>
<%
    request.removeAttribute("message");
%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">详细信息</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
            ,id: 'messageReload'
            ,height: 420
            ,url: '${cps}/message/listMessage.do'
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'messageid', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'content', title: '发送内容', width:820}
                ,{fixed: 'right', width: 200, align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                window.location.href='${cps}/message/editMessage.do?messageid='+data.messageid;
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type: "POST",
                        async:true,
                        url: "${cps}/message/deleteMessage.do",
                        data: {messageid:data.messageid},
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
                table.reload('messageReload',{
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
