package com.zhbit.pojo;

public class User {

    private String userName;
    private String password;
    private String adPhone;
    private int admin;

    public User() {
    }

    public User(String userName, String password, String adPhone, int admin) {
        this.userName = userName;
        this.password = password;
        this.adPhone = adPhone;
        this.admin = admin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", adPhone='" + adPhone + '\'' +
                ", admin=" + admin +
                '}';
    }
}
