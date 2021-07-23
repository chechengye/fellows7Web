<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2021/7/23
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
This is include4 Page
    <!--动态包含-->
    <jsp:include page="include3.jsp"></jsp:include>

    <!--跳转内部转发-->
    <jsp:forward page="include2.jsp"></jsp:forward>
</body>
</html>
