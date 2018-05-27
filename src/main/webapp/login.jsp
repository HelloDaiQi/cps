<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/26
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>
<html>
<head>
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${cps}/static/login/css/style.css" type="text/css" media="all">
    <script type="application/x-javascript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0); }, false);
        function hideURLbar(){
                window.scrollTo(0,1);
        }
    </script>
</head>
<body>
<h1>登录到校园合伙人后台系统</h1>
<div class="container w3layouts agileits">
    <%
        Cookie[] cookies = request.getCookies();
        String autologin = null;
        for(int i=0;cookies!=null&&i<cookies.length;i++){
            if("admin".equals((cookies[i].getName()))){
                autologin = cookies[i].getValue();
                break;
            }
        }
        if(autologin!=null && autologin!=""){
            String[] split = autologin.split("-");
            pageContext.setAttribute("email",split[0]);
            pageContext.setAttribute("password",split[1]);
        }
    %>
    <div class="login w3layouts agileits">
        <h2>登 录</h2>
        <form action="${cps}/login.do" method="post">
            <input type="text" Name="email" value="${pageContext.getAttribute("email")}" placeholder="用户名" required="">
            <input type="password" Name="password" value="${pageContext.getAttribute("password")}" placeholder="密码" required="">

            <ul class="tick w3layouts agileits">
                <li>
                    <input type="checkbox" id="brand1" name="remember" value="true" checked="checked">
                    <label for="brand1"><span></span>记住我</label>
                    &nbsp;&nbsp;&nbsp;
                    <label><span style="color: red">${requestScope.error}</span></label>
                </li>
            </ul>
            <div class="send-button w3layouts agileits">
                <input type="submit" value="登 录">
            </div>
        </form>
        <a href="#">记住密码?</a>
        <div class="social-icons w3layouts agileits">
            <p>- 其他方式登录 -</p>
            <ul>
                <li class="qq"><a href="#">
                    <span class="icons w3layouts agileits"></span>
                    <span class="text w3layouts agileits">QQ</span></a></li>
                <li class="weixin w3ls"><a href="#">
                    <span class="icons w3layouts"></span>
                    <span class="text w3layouts agileits">微信</span></a></li>
                <li class="weibo aits"><a href="#">
                    <span class="icons agileits"></span>
                    <span class="text w3layouts agileits">微博</span></a></li>
                <div class="clear"> </div>
            </ul>
        </div>
        <div class="clear"></div>
    </div>
    <!--<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>-->
    <!--<div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form action="#" method="post">
            <input type="text" Name="Name" placeholder="用户名" required="">
            <input type="text" Name="Email" placeholder="邮箱" required="">
            <input type="password" Name="Password" placeholder="密码" required="">
            <input type="text" Name="Phone Number" placeholder="手机号码" required="">
        </form>
        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="免费注册">
            </form>
        </div>
        <div class="clear"></div>
    </div>-->

    <div class="clear"></div>

</div>

<div class="footer w3layouts agileits">
    <p>Copyright &copy; cps <a href="https://hellodaiqi.github.io/" target="_blank" title="DaiQi">校园合伙人</a> - Collect from <a href="https://hellodaiqi.github.io/" title="DaiQi" target="_blank">校园合伙人</a></p>
</div>

</body>
</html>
