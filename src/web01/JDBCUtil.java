package web01;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类用来获取连接、释放资源
 */
public class JDBCUtil {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        driver = rb.getString("jdbc.driver");
        url = rb.getString("jdbc.url");
        username = rb.getString("jdbc.username");
        password = rb.getString("jdbc.password");
    }


    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){
        try {
            //1、获取驱动管理对象
            Class.forName(driver);
            //2、使用驱动管理对象获取连接
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void releaseRes(Connection conn , Statement stmt , ResultSet rs){
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != stmt){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
