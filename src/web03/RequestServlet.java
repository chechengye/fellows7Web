package web03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/request")
public class RequestServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求行中请求方式
        String method = req.getMethod();
        //所有乱码处理的代码都访问代码块的最前面.
        resp.setContentType("text/html;charset=utf-8");
        //解决请求参数的值中文乱码问题 POST/GET
        req.setCharacterEncoding("utf-8");
        resp.getWriter().write("method = " + method + "\n\r");

        System.out.println("------获取请求资源-------");
        String requestURI = req.getRequestURI();
        resp.getWriter().write("requestURI = " + requestURI + "\n\r");
        StringBuffer requestURL = req.getRequestURL();

        resp.getWriter().write("requestURL = " + requestURL+"\n\r");
        String contextPath = req.getContextPath();//配合重定向使用
        resp.getWriter().write("contextPath = " + contextPath + "\n\r");
        //resp.sendRedirect(req.getContextPath() + "/myHttpServlet");

        System.out.println("---------------------------");
        String queryString = req.getQueryString();//处理字符串非常复杂麻烦，所以不推荐
        resp.getWriter().write("queryString = " + queryString + "\n\r");
        System.out.println("----------获取客户端信息----------");
        //应用场景：管理系统、操作日志 ，带着ip地址
        resp.getWriter().write("getRemoteAddr = " +  req.getRemoteAddr() + "\n\r");
        resp.getWriter().write("getRemoteUser = " +  req.getRemoteUser() + "\n\r");

        System.out.println("---------req获取请求头信息----------");
        String userAgentInfo = req.getHeader("User-Agent");
        resp.getWriter().write("userAgentInfo = " + userAgentInfo + "\n\r");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }
        System.out.println("----------有来源就有referer头----------");
        String referer = req.getHeader("referer");
        resp.getWriter().write("referer = " + referer + "\n\r");
        //此时就可以获取控制来源
        /*if(null != referer && referer.contains("http://localhost")){
            resp.getWriter().write("吴亦凡与王思聪是好哥们...");
        }else{
            resp.getWriter().write("你是倒链者，不允许访问我们的内容.."+"\n\r");
        }*/

        System.out.println("------------获取请求体的内容---------------");
        String name = req.getParameter("name");
        name = new String(name.getBytes("iso8859-1"),"utf-8");//GET方法处理单个请求参数时使用。特殊系统下会用到

        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("-----获取单个属性值-----");
        System.out.println("name = " + name);
        System.out.println(Arrays.toString(hobbies));

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        for(Map.Entry<String, String[]> e : entrySet){
            for(String s : e.getValue()){
                System.out.println("key = " + e.getKey() + ",val = " + s);
            }
        }

    }
}
