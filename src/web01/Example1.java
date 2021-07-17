package web01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC应用
 * 最早期的数据库连接语法 。所有框架的底层实现
 */
public class Example1 {

    public static void main(String[] args) {
        try {
            //1、获取驱动管理对象
            Class.forName("com.mysql.jdbc.Driver");
            //2、使用驱动管理对象获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fellows7?useUnicode=true&characterEncoding=utf-8", "root", "root");
            //3、根据连接对象获取statement对象操作数据库SQL语句
            Statement statement = conn.createStatement();
            //4、编写SQL语句
            String sql = "insert into ums_user(name , sex) values('tianqi' , 1)";
            //5、执行SQL语句
            int rows = statement.executeUpdate(sql);//rows 受影响的行数
            if(rows > 0 ){
                System.out.println("插入记录成功！");
            }else{
                System.out.println("插入记录失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
