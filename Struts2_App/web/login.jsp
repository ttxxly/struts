<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-08-01
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}" />
    <title>登录界面</title>
</head>
<body>
<form action="/user/login.do" method="post">
    <p>账号:<input type="text" name="user.account"></p>
    <p>密码:<input type="password" name="user.password"></p>
    <p><input type="submit" value="登录" ></p>
</form>
</body>
</html>
