package web02;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import web02.bean.PmsProduct;
import web02.bean.UmsUser;

import javax.swing.plaf.PanelUI;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Test
    public void testFn3(){
        PreparedStatement pstmt = null;
        try {
            Connection conn = DbcpPool.getConnection();
            pstmt = conn.prepareStatement("update pms_category set cname = ? where cid = ?");
            pstmt.setString(1,"数码产品");
            pstmt.setInt(2 , 7);
            int rows = pstmt.executeUpdate();
            if(rows > 0){
                System.out.println("更新成功！");
            }else{
                System.out.println("更新失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取用户类别使用DBUtil工具类
     */
    @Test
    public void testFn4(){
        try {
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());//创建好qr对象、且可以访问相关数据库了
            List<UmsUser> umsUserList = qr.query("select uu.id, uu.name , uu.username , uu.password , uu.sex from ums_user uu where uu.is_delete != ?", new BeanListHandler<>(UmsUser.class) , 1);
            System.out.println(umsUserList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID获取商品详情
     */
    @Test
    public void testFn5(){
        try {
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());//创建好qr对象、且可以访问相关数据库了
            //给数据库中的字段起别名 : 数据库字段 as 别名 / 数据库字段 别名  (as 可以省略不写)
            PmsProduct product = qr.query("select pp.p_price as pPrice , pp.pname , pp.pid from pms_product pp where pp.pid = ? ", new BeanHandler<>(PmsProduct.class), 3);
            System.out.println(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取订单数量
     */
    @Test
    public void testFn6(){
        try {
            QueryRunner qr = new QueryRunner(DbcpPool.getDataSource());//创建好qr对象、且可以访问相关数据库了
            //ScalarHandler : 返回值类型是Long  count() 函数： 返回相关内容的数量 通常情况下 * ,还可以以字段名 - 最好是主键 .数字不推荐使用
            Long l = (Long)qr.query("select count(*) from oms_order", new ScalarHandler());
            System.out.println(l);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
