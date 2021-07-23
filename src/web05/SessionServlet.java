package web05;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();//若服务端存在客户端的session会话，则直接获取赋值，否则创建赋值
        System.out.println("JSESSIONID = " + session.getId());
        //动态的将cookie时长与session默认时长进行匹配
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60);//一个小时
        resp.addCookie(cookie);
        session.setAttribute("name" , "zhaoliu");//session可以存储中文。Object类型
        boolean flag = true;
        if(flag){
            session.invalidate();//销毁
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
