package web02;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * DBCP数据库连接池
 * Tomcat底层应用
 */
public class DbcpPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        ResourceBundle rb = ResourceBundle.getBundle("db");
        dataSource.setDriverClassName(rb.getString("jdbc.driver"));
        dataSource.setUrl(rb.getString("jdbc.url"));
        dataSource.setPassword(rb.getString("jdbc.password"));
        dataSource.setUsername(rb.getString("jdbc.username"));
    }

    /**
     * DBCP获取连接对象
     * @return
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DataSource getDataSource(){

        return dataSource;
    }
}
