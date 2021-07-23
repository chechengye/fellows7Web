<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2021/7/23
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%--
    Page指令
    所有的指令 @空格
    contentType : 设置文本编码格式的。resp.setContentType("text/html;charset=UTF-8") .不能省略不写
    language : 语言环境 默认写java （仅仅支持Java）。可以省略不写,若写只能写Java
    errorPage ： 跳转一个错误页面的 .内部转发操作
    isErrorPage : 标记哪个页面是错误页面
    session : 可以控制此页面是否支持session会话
    import:导入Java的类的目录的.单独的存于一行，保证格式工整
    buffer:属性out缓存区可以主动控制 默认是8kb大小 .若是将大小设置为0 就相当于关闭了out缓冲区。所有内容则默认写入response缓存区

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" session="true" buffer="8kb" %>
<html>
<head>
    <title>JSP学习与讲解</title>
</head>
<body>
    <%
        //System.out.println(num); 局部变量，下面定义的是无法被上面功能性代码直接访问。
    %>

    <%
        //会将编写的代码翻译到servlet中service方法中
        int num = 20;
        System.out.println(num);
        method();
        System.out.println(str);
        //int i = 100 / 0;
    %>
    <!--放于表达式和结果对象-->
    <%=1+1%>
    <!--会被翻译到servlet的service方法中out.print()内部-->
    <%="这是会写入浏览器的"%>

    <%--JSP注释语法，仅在翻译后的servlet中可以看到..--%>
    <%!
        //此中内容会被翻译到servlet的成员变量、和成员方法
        String str = "aaaa";
        public int method(){
            return 30;
        }

        List<String> list = new ArrayList<>();
    %>


    <hr>
    <!--9大隐式对象-->
    <%
        out.print("aaaaaaaaaaaaaaaaaaaaaaaaaa");
        out.write("bbbbbbbbbbbbbbbbbbbbbbbbb");
    %>
    cccccccccccccccccccccccccccccccccccc
    <%="ddddddddddddddddddddddddddddddd"%>
    <%
        response.getWriter().write("fffffffffffffffffffffffff");
    %>
    <hr>
    <%
        //pageContext域对象 -- 向四大域中存值
        //pageContext.setAttribute("name" , "wangwu");
        //request.setAttribute("name" , "zhaoliu");
        //session.setAttribute("name" , "tianqi");
        application.setAttribute("name" , "guanguan");
        //域由小到大  pageContext < request < session < application域
        response.getWriter().write(pageContext.findAttribute("name") + "");//从域中查询某个key。会从最小，最近的域中取值
        //pageContext是可以获取其它8大隐式对象的。
        request.getContextPath();//应用的上下文路径
        //pageContext.getRe
    %>

</body>
</html>
