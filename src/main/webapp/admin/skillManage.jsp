<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/3/2
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>技能信息管理</title>
    <%@include file="public/headManage.jsp" %>
</head>
<body>
<fieldset class="layui-elem-field site-demo-button" style="margin-top: 10px; border: 0px">
    <div>
        <div class="reloadForm layui-form">
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <button class="layui-btn" type="button" onclick="javascript:window.location.href='${cps}/skill/editSkill.do'">添加技能</button>
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
                        <option value="2">技能名称</option>
                    </select>
                </div>
                <div class="layui-input-inline" style="width: 100px;">
                    <button class="searchBtn layui-btn" data-type="reload">查找技能</button>
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
            ,id: 'skillReload'
            ,height: 420
            ,url: '${cps}/skill/listSkill.do'
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'skillid', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'skillname', title: '技能名称', width:250}
                ,{field: 'introduction', title: '技能简介', width:580, sort: true}
                ,{fixed: 'right', width: 180, align:'center', toolbar: '#barDemo'}
            ]]
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'detail'){
                window.location.href='${cps}/skill/editSkill.do?skillid='+data.skillid;
            } else if(layEvent === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type: "POST",
                        async:true,
                        url: "${cps}/skill/deleteSkill.do",
                        data: {skillid:data.skillid},
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
                table.reload('skillReload',{
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
