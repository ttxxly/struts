<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-31
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
  </head>
  <body>
    这是我的第一个struts2应用程序,传入的信息为：${requestScope.message}
  <hr/>
    当前登录用户为:${user.account}
  <hr>
  request: ${req}<br/>
  session: ${ses}<<br>
  </body>
</html>
