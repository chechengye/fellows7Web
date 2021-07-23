<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="web04.bean.UmsUser" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web04.bean.Car" %>
<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2021/7/23
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL与JSTL学习</title>
</head>
<body>

    <%
        pageContext.setAttribute("name","beibei");
        request.setAttribute("age","33");
        request.setAttribute("name","guanguan");
        Car car = new Car();
        car.setColor("红色");
        UmsUser umsUser = new UmsUser();
        umsUser.setName("张三");
        umsUser.setEmail("zhangsan@163.com");
        umsUser.setCar(car);
        session.setAttribute("user" , umsUser);
        List<UmsUser> umsUserList = new ArrayList<>();
        umsUserList.add(umsUser);
        UmsUser umsUser1 = new UmsUser();
        umsUser1.setName("李思");
        umsUser1.setEmail("lisi@163.com");
        umsUserList.add(umsUser1);
        application.setAttribute("umsUserList" , umsUserList);

    %>
    <!--可以直接使用key键的方式，取值-->
    ${pageScope.name}
    ${requestScope.age}
    <!--对象类型作为key 的话、需要使用对象的属性作为它的子键-->
    ${sessionScope.user.email}
    ${sessionScope.user.car.color}
    <!--从数组或者列表中取值需要使用[index]-->
    ${applicationScope.umsUserList[1].name}

    <!--替代pageContext.findAttribute()方法-->
    <!--就近原则 page域 < request域 < session 域 < application域-->
    <!--推荐与经常使用的-->
    ${name}

    <hr>

    ${header["User-Agent"]}
    <hr>
    ${pageContext.request.contextPath} <!--获取上下文路径替换request.getContextPath()-->


    <hr>
    <!--JSTL标签库应用 foreach代表循环操作 var : 域变量 begin开始索引，end结束索引-->
    <c:forEach begin="0" end="10" var="i">
        <c:if test="${i == 5}">
            ${i + 20}
        </c:if>
       <c:if test="${i != 5}">
           ${i}
       </c:if>
    </c:forEach>

    <hr>
    <!--varStatus中的变量 称为 行数、需要与count属性配合使用-->
    <c:forEach items="${umsUserList}" var="user" varStatus="vs" >
        编号: ${vs.count} &nbsp;&nbsp; 名称 : ${user.name}   &nbsp;&nbsp; 邮箱: ${user.email} <br>
    </c:forEach>
</body>
</html>
