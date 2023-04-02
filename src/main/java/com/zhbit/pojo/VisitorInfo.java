package com.zhbit.pojo;

public class VisitorInfo {

    private int id;
    private String visPhone;
    private String carNo;

    public VisitorInfo(int id, String visPhone, String carNo) {
        this.id = id;
        this.visPhone = visPhone;
        this.carNo = carNo;
    }

    public VisitorInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisPhone() {
        return visPhone;
    }

    public void setVisPhone(String visPhone) {
        this.visPhone = visPhone;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
}
