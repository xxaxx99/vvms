package com.zhbit.pojo;

public class Order {
    private int id;
    private String phone;
    private float money;
    private String carNumber;
    private float time;

    public Order() {
    }

    public Order(int id, String phone, float money, String carNumber, float time) {
        this.id = id;
        this.phone = phone;
        this.money = money;
        this.carNumber = carNumber;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
}
