package web03;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import web02.C3p0Pool;
import web02.bean.UmsUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username = " + username +" ,password = " + password);
        UmsUser umsUser = login(username, password);
        if(null != umsUser){
            //携带用户信息过去
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else{
            //应该回到login.html 并提示用户名与密码
            System.out.println("用户名或密码错误");
        }
    }

    private UmsUser login(String username, String password) {
        try {
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            UmsUser user = qr.query("select uu.name , uu.id from ums_user uu where uu.username = ? and uu.password = ?", new BeanHandler<>(UmsUser.class), username, password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req  , resp);
    }
}
