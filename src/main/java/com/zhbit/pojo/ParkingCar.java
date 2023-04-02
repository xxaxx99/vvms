package com.zhbit.pojo;

public class ParkingCar {
    private String carNo;
    private String inTime;

    public ParkingCar(){

    }

    public ParkingCar(String carNo, String inTime) {
        this.carNo = carNo;
        this.inTime = inTime;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    @Override
    public String toString() {
        return "ParkingCar{" +
                "carNo='" + carNo + '\'' +
                ", inTime='" + inTime + '\'' +
                '}';
    }
}
