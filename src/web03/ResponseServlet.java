package web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //使用response对象控制状态码 - 响应行中的
        resp.setStatus(500);//伪造状态码

        //控制响应头  add :可以加入多个重复的值。 set设定唯一的key值
        resp.addHeader("name" , "zhangsan");
        resp.addHeader("name" , "lisi");
        resp.addIntHeader("age" , 22);
        resp.addDateHeader("birthday" , new Date().getTime());
        resp.setHeader("name","wangwu");

        //设置重定向: 重定向跳转的页面，地址栏会发生改变
        /*resp.setStatus(302);
        resp.setHeader("Location" , "/myHttpServlet");*/

        //封装好的重定向方法 sendRedirect(url);
        //resp.sendRedirect("/test.html");

        //处理乱码
        resp.setContentType("text/html;charset=utf-8");//包含了setCharacterEncoding("utf-8")
        //通过response设置响应体 write() : 只能向当前页写入内容，若是有调用重定向跳转页面，则不会显示相应内容
        resp.getWriter().write("这是测试向response缓冲区中写入内容...");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
