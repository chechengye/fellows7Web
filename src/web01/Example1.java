package web01;

import org.junit.Test;

import java.sql.*;

/**
 * JDBC应用
 * 最早期的数据库连接语法 。所有框架的底层实现
 */
public class Example1 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1、获取驱动管理对象
            Class.forName("com.mysql.jdbc.Driver");
            //2、使用驱动管理对象获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fellows7?useUnicode=true&characterEncoding=utf-8", "root", "root");
            //3、根据连接对象获取statement对象操作数据库SQL语句
            stmt = conn.createStatement();
            //4、编写SQL语句
            String sql = "insert into ums_user(name , sex) values('tianqi' , 1)";
            //5、执行SQL语句
            int rows = stmt.executeUpdate(sql);//rows 受影响的行数
            if(rows > 0 ){
                System.out.println("插入记录成功！");
            }else{
                System.out.println("插入记录失败！");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.releaseRes(conn , stmt , null);
        }
    }


    @Test
    public void testFn() throws ClassNotFoundException, SQLException {
        //1、获取驱动管理对象
        Class.forName("com.mysql.jdbc.Driver");
        //2、使用驱动管理对象获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fellows7?useUnicode=true&characterEncoding=utf-8", "root", "root");
        //3、根据连接对象获取statement对象操作数据库SQL语句
        Statement statement = conn.createStatement();
        //4、编写SQL语句
        String sql = "select id , name , sex from ums_user";
        //5、执行SQL语句
        ResultSet rs = statement.executeQuery(sql);//rows 受影响的行数
        while (rs.next()){
            System.out.println("ID ： " + rs.getInt("id") + " , name : " + rs.getString(2) + " , sex : " + rs.getInt("sex"));
        }
    }

    @Test
    public void testFn1() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = conn.createStatement();

        //4、编写SQL语句
        String sql = "delete from ums_user where id = 6";

        int rows = stmt.executeUpdate(sql);
        if(rows > 0){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }

        JDBCUtil.releaseRes(conn , stmt , null);
    }

    /**
     * SQL攻击的演示
     */
    @Test
    public void testFn2(){
        login("zhangsan" , "123");
    }

    private void login(String username, String password) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            /*stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);*/

            String sql = "select id , name from ums_user where username = ? and password = ? ";//? : 占位符的方式
            pstm = conn.prepareStatement(sql);//生成预编译对象
            pstm.setString(1 , username);
            pstm.setString(2 , password);
            rs = pstm.executeQuery();


            if(rs.next()){//记录存在
                System.out.println("欢迎，" + rs.getString("name"));
            }else{
                System.out.println("用户名或密码错误！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
