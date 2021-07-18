package web02.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class PmsProduct implements Serializable{

    private Integer pid;
    private String pname;
    private BigDecimal pPrice;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "PmsProduct{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pPrice=" + pPrice +
                '}';
    }
}
