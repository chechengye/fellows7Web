package web03;

import javax.servlet.ServletContext;
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
 *
 *    ServletContext是一个域对象 -- 作用范围整个web应用
 *    生命周期：随着web项目被部署启动，而产生。随着web服务关闭或卸载而消亡
 *    四大域对象之一，范围最大的。
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
        //this.getServletConfig().getServletContext()
        ServletContext servletContext = this.getServletContext();
        System.out.println("----" + servletContext.getInitParameter("testContext"));
        System.out.println("真实路径 : " + servletContext.getRealPath("WEB-INF/aa.txt"));
        servletContext.setAttribute("name" , "test in val");
    }
}
