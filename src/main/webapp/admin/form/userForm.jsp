<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/8
  Time: 16:37
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
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <link href="${cps}/static/selectMultiple/css/public.css" rel="stylesheet" media="all">
    <script src="${cps}/static/selectMultiple/layui/layui.js"></script>
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
                if(value.length < 2 || value.length>10){
                    return '昵称至少2个字符,至多10个字符';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听指定开关
        form.on('switch(switchTest)', function(data){
            layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
                offset: '6px'
            });
            layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
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
            ,url: '${cps}/user/uploadUserImage.do'
            ,method:'post'
            ,data:{userid:'${user.userid}'}
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
    <legend align="center">用户信息详情</legend>
</fieldset>

<form class="layui-form" action="${cps}/user/saveUser.do">
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
            <input name="nickname" value="${requestScope.user.nickname}" lay-verify="title" autocomplete="off" placeholder="请输入昵称" class="layui-input" type="text">
        </div>
        <%-- 添加用户时,密码默认123456,管理员也不允许修改用户的密码 --%>
        <%--<label class="layui-form-label">用户密码</label>
        <div class="layui-input-inline">
            <input name="password" value="${requestScope.user.password}" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" type="password">
        </div>--%>
        <div class="layui-input-inline">
            <input name="userid" value="${requestScope.user.userid}" placeholder="请输入ID" autocomplete="off" class="layui-input" type="hidden">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
            <div class="layui-input-inline">
                <input name="email" value="${requestScope.user.email}" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">手&nbsp;&nbsp;机&nbsp;&nbsp;号</label>
            <div class="layui-input-inline">
                <input name="phonenumber" value="${requestScope.user.phonenumber}" lay-verify="phone" placeholder="请输入手机号" autocomplete="off" class="layui-input" type="tel">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">Q&nbsp;&nbsp;Q&nbsp;&nbsp;号</label>
            <div class="layui-input-inline">
                <input name="qqnumber" value="${requestScope.user.qqnumber}" lay-verify="number" placeholder="请输入QQ号" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>
        <div class="layui-input-block">
            <c:choose>
                <c:when test="${requestScope.user.gender=='男'}">
                    <input name="gender" value="男" title="男" checked="" type="radio">
                    <input name="gender" value="女" title="女" type="radio">
                </c:when>
                <c:otherwise>
                    <input name="gender" value="男" title="男" type="radio">
                    <input name="gender" value="女" title="女" checked="" type="radio">
                </c:otherwise>
            </c:choose>
            <%--<input name="sex" value="禁" title="禁用" disabled="" type="radio">--%>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校</label>
            <div class="layui-input-inline">
                <select name="school" lay-verify="required" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="school" items="${schoolList}">
                        <c:choose>
                            <c:when test="${school.schoolid==requestScope.user.school}">
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
                            <c:when test="${grade.gradeid==requestScope.user.grade}">
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
        <div class="layui-inline">
            <label class="layui-form-label">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业</label>
            <div class="layui-input-inline">
                <select name="professional" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="professional" items="${professionalList}">
                        <c:choose>
                            <c:when test="${professional.professionalid==requestScope.user.professional}">
                                <option value="${professional.professionalid}" selected="">${professional.professionalname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${professional.professionalid}">${professional.professionalname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">主要技能</label>
            <div class="layui-input-inline">
                <select name="majorskill" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="skill" items="${skillList}">
                        <c:choose>
                            <c:when test="${skill.skillid==requestScope.user.majorskill}">
                                <option value="${skill.skillid}" selected="">${skill.skillname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${skill.skillid}">${skill.skillname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">熟&nbsp;&nbsp;练&nbsp;&nbsp;度</label>
            <div class="layui-input-inline">
                <select name="majorskillproficiency" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="proficiency" items="${proficiencyList}">
                        <c:choose>
                            <c:when test="${proficiency.proficiencyid==requestScope.user.majorskillproficiency}">
                                <option value="${proficiency.proficiencyid}" selected="">${proficiency.proficiencyname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${proficiency.proficiencyid}">${proficiency.proficiencyname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">次要技能</label>
            <div class="layui-input-inline">
                <select name="minorskill" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="skill" items="${skillList}">
                        <c:choose>
                            <c:when test="${skill.skillid==requestScope.user.minorskill}">
                                <option value="${skill.skillid}" selected="">${skill.skillname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${skill.skillid}">${skill.skillname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">熟&nbsp;&nbsp;练&nbsp;&nbsp;度</label>
            <div class="layui-input-inline">
                <select name="minorskillproficiency" lay-search="">
                    <option value="">请选择...</option>
                    <c:forEach var="proficiency" items="${proficiencyList}">
                        <c:choose>
                            <c:when test="${proficiency.proficiencyid==requestScope.user.minorskillproficiency}">
                                <option value="${proficiency.proficiencyid}" selected="">${proficiency.proficiencyname}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${proficiency.proficiencyid}">${proficiency.proficiencyname}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">工作经验(年)</label>
            <div class="layui-input-inline">
                <input name="experience" value="${requestScope.user.experience}" lay-verify="number" min="0" max="50" placeholder="请输入工作经验" autocomplete="off" class="layui-input" type="number">
            </div>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">简介</label>
        <div class="layui-input-block">
            <textarea name="introduction" placeholder="请输入内容"  class="layui-textarea">${requestScope.user.introduction}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">用户角色</label>
        <div class="layui-input-block">
            <select lay-filter="roleids" multiple name="roleids" lay-verify="required">
                <option value="">请选择...</option>
                <c:forEach var="role" items="${roleList}">
                    <option value="${role.roleid}">${role.rolename}</option>
                </c:forEach>
                <c:forEach var="userRole" items="${userRoleList}">
                    <option value="${userRole.roleid}" selected="">${userRole.rolename}</option>
                </c:forEach>
            </select>
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
