<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2021/7/26
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步Ajax访问</title>
</head>
<script src="../js/jquery-1.11.3.min.js"></script>
<script>

    function testFn() {
        //1、创建Ajax引擎对象
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2、绑定事件监听
        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                alert(xmlhttp.responseText);
            }
        }
        //3、建立连接
        xmlhttp.open("GET","${pageContext.request.contextPath}/ajax?name=lily",true);
        //4、发送请求
        xmlhttp.send();
    }

    function testFnPost() {
        //1、创建Ajax引擎对象
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        //2、绑定事件监听
        xmlhttp.onreadystatechange=function() {
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                alert(xmlhttp.responseText);
            }
        }
        //3、建立连接
        xmlhttp.open("POST","${pageContext.request.contextPath}/ajax",false);
        //4、设定请求头、标识是表单参数
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        //4、发送请求
        xmlhttp.send("name=lily&age=23");

    }

    function testJQFnGet() {
        $.get("${pageContext.request.contextPath}/ajax", { "name": "John", "time": "2pm" },
            function(data){//监听函数
                alert("Data Loaded: " + data);
            } , "text");
    }

    function testJQAjaxFn() {
        //推荐使用的ajax异步技术
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/ajax",
            data: { "name": "John", "time": "2pm" },
            success: function(data){
                alert( "Data Saved: " + data.name );
            },
            error:function (data) {
              alert("错误监听...")
            },
            dataType: "json" ,
            async : true
        });
    }

</script>
<body>
    <input type="button" value="测试JS发起Ajax请求异步" onclick="testFn()"/>

    <input type="button" value="测试JS发起Ajax请求同步" onclick="testFnPost()"/>

    <input type="button" value="测试JQ发起GET请求异步" onclick="testJQFnGet()"/>

    <input type="button" value="测试JQ发起Ajax请求" onclick="testJQAjaxFn()"/>

    <input type="button" value="Test" onclick="alert('test')"/>
</body>
</html>
