package web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 所有的注解，多个属性之间都是使用,号分割。而且都是key = value的形式
 *    name = "MyHttpServlet" 可以省略不写。因为注解是配于Servlet类上面的，可直接找寻到
 *    若注解中只有一个属性，属性名称也可以省略不写。
 */
@WebServlet("/myHttpServlet")
public class MyHttpServlet  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);//让代码出口统一
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //做相关业务处理
        System.out.println("doPost...");

    }
}
