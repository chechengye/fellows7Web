<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2021/7/26
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON案例测试</title>
</head>
<script>
    //默认支持Json格式
    /**
     * public class User{
     *      private String username ;
     *      private String age;
     * }
     *
     */
    var user = {"username":"zhangsan","age":23,"name":"张三"};//成对的{}一定要写
    alert(user.name)
    //----------------------
    var productList = [{"pname":"华为手机","shopPrice":3000.55},{"pname":"苹果电脑","shopPrice":13000.55}];
    //对象集合
    for(var i = 0 ; i < productList.length ; i++){
        alert(productList[i].pname + "," + productList[i].shopPrice)
    }
    //{key1:val1 , key2:{} , key3:val3}
    var orderDetail = {"code":200 , "data":{"oid":36 , "ono":7436746373265326221,"createTime":"2021-7-26"} , "message":"成功"};
    if(orderDetail.code == 200){
        alert(orderDetail.data.ono)
    }
    var orderList = {"code":200 , "data":[{"oid":36 , "ono":7436746373265326221,"createTime":"2021-7-26" , "orderItems":[{"pname":"华为手机","shopPrice":3000.55},{"pname":"苹果电脑","shopPrice":13000.55}]}] , "message":"成功"};
    alert(orderList.data[0].orderItems[0].pname)
</script>
<body>

</body>
</html>
