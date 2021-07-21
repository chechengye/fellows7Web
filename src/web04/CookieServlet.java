package web04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、创建一个cookie出来。产生一次会话
        Cookie cookie = new Cookie("name" , "guanguan");
        //设置cookie最大时效
        cookie.setMaxAge(60*30);//单位是s 设置半个小时
        //设置访问路径
        //cookie.setPath("/cookie");
        //2、需要使用resp响应对象，将此cookie响应回给浏览器
        resp.addCookie(cookie);
        //设置第二个Cookie
        Cookie cookie1 = new Cookie("age" ,"33");
        resp.addCookie(cookie1);


    }
}
