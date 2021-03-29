package com.weibo.entity;
/*
    @author weibo
    @date 2021/1/28 - 15:29
*/

public class Car {
    private String city_name;
    private int car_total_num;
    private int car_rest_num;
    private double car_price;

    public Car() {

    }

    public Car(String city_name, int car_total_num, int car_rest_num, double car_price) {
        this.city_name = city_name;
        this.car_total_num = car_total_num;
        this.car_rest_num = car_rest_num;
        this.car_price = car_price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "city_name='" + city_name + '\'' +
                ", car_total_num=" + car_total_num +
                ", car_rest_num=" + car_rest_num +
                ", car_price=" + car_price +
                '}';
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getCar_total_num() {
        return car_total_num;
    }

    public void setCar_total_num(int car_total_num) {
        this.car_total_num = car_total_num;
    }

    public int getCar_rest_num() {
        return car_rest_num;
    }

    public void setCar_rest_num(int car_rest_num) {
        this.car_rest_num = car_rest_num;
    }

    public double getCar_price() {
        return car_price;
    }

    public void setCar_price(double car_price) {
        this.car_price = car_price;
    }
}
