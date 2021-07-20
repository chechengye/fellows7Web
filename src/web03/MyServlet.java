package web03;

import javax.servlet.*;
import java.io.IOException;

/**
 * 实现Servlet接口重写相关方法
 *
 * 生命周期：
 *
 * 默认Servlet配置初始化方法init只会在第一次访问的时候调用一次。初始化配置的地方
 * 服务方法service是每次访问接口url-pattern都会调用的方法。业务代码编写的地方
 * 销毁/销亡方法destroy()，在服务器被停掉，或者web应用被移除的时候 ，会调用。
 *
 */
public class MyServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方法...");
        System.out.println(servletConfig.getServletName());
        String parameter = servletConfig.getInitParameter("jdbc.url");
        System.out.println(parameter);
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);

        System.out.println(servletContext.getAttribute("name"));
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务方法...");
        //处理响应回页面的中文乱码问题
        servletResponse.setContentType("text/html;charset=utf-8");
        servletResponse.getWriter().write("<html lang=\"en\">");
        servletResponse.getWriter().write("<head>");
        servletResponse.getWriter().write("<meta charset=\"UTF-8\">");
        servletResponse.getWriter().write("<title>Title</title>");
        servletResponse.getWriter().write("</head>");
        servletResponse.getWriter().write("<body>");
        servletResponse.getWriter().write("测试Write方法");
        servletResponse.getWriter().write("</body>");
        servletResponse.getWriter().write("</html>");

        //System.out.println("域对象中的值： " + this.getServletConfig().getServletContext().getAttribute("name"));
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }


}
