<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2021/7/23
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include2</title>
</head>
<body>
    This is include2 Page
    <!--内容展示先后顺序取决于页面的引入位置-->
    <!--静态包含-->
    <%@ include file="include1.jsp"%>
</body>
</html>
