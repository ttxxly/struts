<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-31
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}" />
    <title>添加</title>
</head>
<body>
<%--<form action="/common1/User-add.action" method="post">
    <p>账号：<input type="text" name="account"></p>
    <p>密码：<input type="text" name="password"></p>
    <p><input type="submit" value="登录"></p>
</form>--%>
<form action="/common1/User-add.action" method="post">
    <p>账号：<input type="text" name="user.account"></p>
    <p>密码：<input type="text" name="user.password"></p>
    <p><input type="submit" value="登录"></p>
</form>
</body>
</html>
