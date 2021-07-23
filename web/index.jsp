<%@ page import="web02.bean.UmsUser" %><%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2021/7/16
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Web应用</title>
  </head>
  <body>
  <%="欢迎," + ((UmsUser)session.getAttribute("user")).getName()%>
  第一次部署Web应用
  </body>
</html>
