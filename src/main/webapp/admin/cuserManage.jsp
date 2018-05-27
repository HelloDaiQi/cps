<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/28
  Time: 10:15
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
                    &nbsp;<%--<button class="layui-btn" type="button" onclick="javascript:window.location.href='${cps}/cuser/editCuser.do'">添加认证用户</button>--%>
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
                        <option value="2">真实姓名</option>
                        <option value="3">身份证号</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 100px;">
                    <button class="searchBtn layui-btn" data-type="reload">查找用户</button>
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
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['layer', 'table', 'element', 'form'], function(){
        //var laydate = layui.laydate //日期
        layer = layui.layer //弹层
            ,table = layui.table //表格
            ,element = layui.element //元素操作
            ,form=layui.form;

        if(${requestScope.message !=null}){
            layer.msg('${message}');
            //request.removeAttribute("message");
        }

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.msg('切换了：'+ this.innerHTML);
            console.log(data);
        });

        //执行一个 table 实例
        table.render({
            elem: '#test'
            ,id: 'cuserReload'
            ,height: 420
            ,url: '${cps}/cuser/listCuser.do'
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'cuserid', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'realname', title: '真实姓名', width:100}
                ,{field: 'cardnumber', title: '身份证号', width:170, sort: true}
                ,{field: 'reason', title: '认证理由', width:240}
                ,{field: 'opinion', title: '审核意见', width:240}
                ,{field: 'status', title: '状态', width: 100, sort: true}
                ,{fixed: 'right', width: 180, align:'center', toolbar: '#barDemo'}
            ]]
        });


        //监听工具条
        table.on('tool(demo)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                window.location.href='${cps}/cuser/editCuser.do?cuserid='+data.cuserid;
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type: "POST",
                        async:true,
                        url: "${cps}/cuser/deleteCuser.do",
                        data: { cuserid:data.cuserid},
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
                });
            }
        });

        var reloadActive = {
            reload:function () {
                var content = $('#content').val();
                var condition = $('#condition').val();
                //执行重载
                table.reload('cuserReload',{
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