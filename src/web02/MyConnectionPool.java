package web02;

import web01.JDBCUtil;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 自定义连接池
 */
public class MyConnectionPool implements DataSource{

    static List<Connection> connPool = new ArrayList<>(10);

    public MyConnectionPool(){
        for(int i = 0 ; i < 10 ; i++){
            connPool.add(JDBCUtil.getConnection());
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(connPool.size() == 0){
            for(int i = 0 ; i < 10 ; i++){
                connPool.add(JDBCUtil.getConnection());
            }
        }
        return connPool.remove(0);
    }
    /**
     * 归还连接到连接池
     */
    public static void returnConn(Connection conn){
        connPool.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
