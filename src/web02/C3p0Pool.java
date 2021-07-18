package web02;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0连接池 - 开源
 * 可以支持配置池子容量、超时时间、对并发支持非常好
 * 不需要主动释放、归还连接。用完自行回收
 * 技术栈目前使用： Hibernate 、Spring等
 * 支持独有的配置文件c3p0-config.xml
 */
public class C3p0Pool {

    private static  ComboPooledDataSource dataSource;

    static {
            dataSource = new ComboPooledDataSource();//会默认去src/resource资源目录下寻找一个才c3p0-config.xml的配置文件
            /*
            try {
            手动配置需要
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/fellows7?useUnicode=true&characterEncoding=utf-8");
            dataSource.setUser("root");
            dataSource.setPassword("root");
            dataSource.setMinPoolSize(10);
             } catch (PropertyVetoException e) {
            e.printStackTrace();
            }
            */
    }

    /**
     * 通过C3P0连接池获取连接对象
     * @return
     */
    public static Connection getConnection(){
        try {
            Connection conn = dataSource.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
