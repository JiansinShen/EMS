package com.weibo.entity;
/*
    @author weibo
    @date 2021/1/28 - 15:31
*/

import java.util.Date;

public class Flight {
    private String flight_num;
    private double flight_price;
    private int flight_total_seats;
    private int flight_rest_seats;
    private String flight_from_city;
    private String flight_to_city;

    public Flight() {

    }

    public Flight(String flight_num, double flight_price, int flight_total_seats, int flight_rest_seats, String flight_from_city, String flight_to_city) {
        this.flight_num = flight_num;
        this.flight_price = flight_price;
        this.flight_total_seats = flight_total_seats;
        this.flight_rest_seats = flight_rest_seats;
        this.flight_from_city = flight_from_city;
        this.flight_to_city = flight_to_city;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_num='" + flight_num + '\'' +
                ", flight_price=" + flight_price +
                ", flight_total_seats=" + flight_total_seats +
                ", flight_rest_seats=" + flight_rest_seats +
                ", flight_from_city='" + flight_from_city + '\'' +
                ", flight_to_city='" + flight_to_city + '\'' +
                '}';
    }

    public String getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(String flight_num) {
        this.flight_num = flight_num;
    }

    public double getFlight_price() {
        return flight_price;
    }

    public void setFlight_price(double flight_price) {
        this.flight_price = flight_price;
    }

    public int getFlight_total_seats() {
        return flight_total_seats;
    }

    public void setFlight_total_seats(int flight_total_seats) {
        this.flight_total_seats = flight_total_seats;
    }

    public int getFlight_rest_seats() {
        return flight_rest_seats;
    }

    public void setFlight_rest_seats(int flight_rest_seats) {
        this.flight_rest_seats = flight_rest_seats;
    }

    public String getFlight_from_city() {
        return flight_from_city;
    }

    public void setFlight_from_city(String flight_from_city) {
        this.flight_from_city = flight_from_city;
    }

    public String getFlight_to_city() {
        return flight_to_city;
    }

    public void setFlight_to_city(String flight_to_city) {
        this.flight_to_city = flight_to_city;
    }
}
