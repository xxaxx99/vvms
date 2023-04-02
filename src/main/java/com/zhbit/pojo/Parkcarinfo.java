package com.zhbit.pojo;

public class Parkcarinfo {
    private int parkNo;  //停车场号码
    private int allspace;  //所有车位数量
    private int occupied;  //已被占用车位数量

    public Parkcarinfo(int parkNo, int allspace, int occupied) {
        this.parkNo = parkNo;
        this.allspace = allspace;
        this.occupied = occupied;
    }
    public Parkcarinfo() {
    }
    public int getParkNo() {
        return parkNo;
    }

    public void setParkNo(int parkNo) {
        this.parkNo = parkNo;
    }

    public int getAllspace() {
        return allspace;
    }

    public void setAllspace(int allspace) {
        this.allspace = allspace;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }
}
