package web04;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import web02.C3p0Pool;
import web04.bean.UmsUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            Map<String, String[]> map = req.getParameterMap();
            UmsUser umsUser = new UmsUser();
            //此时如何封装此对象
            BeanUtils.populate(umsUser , map);
            String[] hobbys = map.get("hobby");
            String hobby = Arrays.toString(hobbys);
            System.out.println("hobbys = " + hobby);
            hobby = hobby.substring(1 , hobby.length() - 1);
            umsUser.setHobby(hobby);
            int rows = registerUser(umsUser);
            if(rows > 0){//注册成功
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }else{
                System.out.println("注册失败！");
                //内部转发无需添加应用上下文路径 - 为啥？地址栏都没有发生变化、内部之间跳转
                req.getRequestDispatcher("/register.html").forward(req , resp);//forward:一定要写
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private int registerUser(UmsUser umsUser) {
        try {
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            int rows = qr.update("insert into ums_user values(null , ? , ? ,? , ? ,? , ? ,? ,?)"
                    , umsUser.getName()
                    , umsUser.getSex()
                    , umsUser.getUsername()
                    , umsUser.getPassword()
                    , 0 , umsUser.getMobile()
                    , umsUser.getEmail()
                    , umsUser.getHobby());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
