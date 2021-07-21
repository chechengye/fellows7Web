package web04.bean;

import java.io.Serializable;

public class UmsUser implements Serializable {

    private Integer id;
    private String name;
    private int sex;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private String hobby;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "UmsUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
