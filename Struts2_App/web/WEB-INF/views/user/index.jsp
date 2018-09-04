<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-08-01
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}" />
    <title>用户主页</title>
</head>
<body>
    当前登录用户:${sessionScope.current_user}
    <hr>
    <a href="/user/add.do">新增用户</a>
    <br>
    信息为: ${message}
</body>
</html>
