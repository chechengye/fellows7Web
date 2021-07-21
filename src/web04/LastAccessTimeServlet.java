package web04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cookie实例：记录上次访问时间
 */
@WebServlet("/lastAccessTime")
public class LastAccessTimeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");//HH是24小时制 。hh是12小时制
        String lastTime = null;
        //获取客户端中携带的cookie使用req对象
        Cookie[] cookies = req.getCookies();
        if(null != cookies && cookies.length > 0){//确保至少存在一个cookie记录
            for(Cookie c : cookies){
                if(null != c){
                    if(c.getName().equals("lastTime")){
                        lastTime = c.getValue();
                    }
                }
            }
        }


        if(null == lastTime){
            resp.getWriter().write("您是第一次访问 , 当前时间为: " + df.format(new Date()).replace("+" , " "));
        }else{
            resp.getWriter().write("您上次的访问时间为 : " + lastTime.replace("+"," "));
        }
        //cookie中中文与空格不支持。需要特殊处理
        Cookie cookie = new Cookie("lastTime" , df.format(new Date()));
        cookie.setPath("/lastAccessTime");
        cookie.setMaxAge(60 * 60 * 24 * 7);//一周
        resp.addCookie(cookie);

    }
}
