package web04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieTest")
public class CookieTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端中携带的cookie使用req对象
        Cookie[] cookies = req.getCookies();
        if(null != cookies && cookies.length > 0){//确保至少存在一个cookie记录
            for(Cookie c : cookies){
                if(null != c){
                    if(c.getName().equals("name")){
                        System.out.println("val = " + c.getValue());
                    }
                }
            }
        }
    }
}
