package com.weibo.entity;
/*
    @author weibo
    @date 2021/1/28 - 15:34
*/

public class Hotel {
    private String hotel_name;
    private double hotel_price;
    private int hotel_total_room;
    private int hotel_rest_room;

    public Hotel() {

    }

    public Hotel(String hotel_name, double hotel_price, int hotel_total_room, int hotel_rest_room) {
        this.hotel_name = hotel_name;
        this.hotel_price = hotel_price;
        this.hotel_total_room = hotel_total_room;
        this.hotel_rest_room = hotel_rest_room;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotel_name='" + hotel_name + '\'' +
                ", hotel_price=" + hotel_price +
                ", hotel_total_room=" + hotel_total_room +
                ", hotel_rest_room=" + hotel_rest_room +
                '}';
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public double getHotel_price() {
        return hotel_price;
    }

    public void setHotel_price(double hotel_price) {
        this.hotel_price = hotel_price;
    }

    public int getHotel_total_room() {
        return hotel_total_room;
    }

    public void setHotel_total_room(int hotel_total_room) {
        this.hotel_total_room = hotel_total_room;
    }

    public int getHotel_rest_room() {
        return hotel_rest_room;
    }

    public void setHotel_rest_room(int hotel_rest_room) {
        this.hotel_rest_room = hotel_rest_room;
    }
}
