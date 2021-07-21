<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<!-- method : 默认是get-->
<form action="/login" method="post">
    <div style="color: red"> <%=request.getAttribute("errMsg") == null ? "" : request.getAttribute("errMsg")%></div>
    用户名: <input type="text" name="username"/><br>
    密码: <input type="password" name="password"/><br/>
    <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
</form>
</body>
</html>