package web02;

import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example1 {


    @Test
    public void testFn(){
        MyConnectionPool pool = new MyConnectionPool();
        Connection conn = null;
        try {
            conn = pool.getConnection();

            PreparedStatement pstm = conn.prepareStatement("select o.ono , o.create_time from oms_order o ");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                System.out.println("订单号： " + rs.getString("ono") + " , 日期 : " + rs.getString("create_time"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MyConnectionPool.returnConn(conn);
        }
    }

    @Test
    public void testFn2(){
        try {
            Connection conn = C3p0Pool.getConnection();
            PreparedStatement pmst = conn.prepareStatement("insert into pms_product(p_price , pname) VALUES (? , ?)");
            pmst.setBigDecimal(1 , new BigDecimal(4000));
            pmst.setString(2 , "华为手机");
            int rows = pmst.executeUpdate();

            if(rows > 0 ){
                System.out.println("添加商品成功！");
            }else{
                System.out.println("添加商品失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
