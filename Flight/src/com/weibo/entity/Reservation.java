package com.weibo.entity;
/*
    @author weibo
    @date 2021/1/28 - 15:36
*/

public class Reservation {
    private String reservation_name;
    private int reservation_type;
    private String user_name;

    public Reservation() {

    }

    public Reservation(String reservation_name, int reservation_type, String user_name) {
        this.reservation_name = reservation_name;
        this.reservation_type = reservation_type;
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_name='" + reservation_name + '\'' +
                ", reservation_type=" + reservation_type +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    public String getReservation_name() {
        return reservation_name;
    }

    public void setReservation_name(String reservation_name) {
        this.reservation_name = reservation_name;
    }

    public int getReservation_type() {
        return reservation_type;
    }

    public void setReservation_type(int reservation_type) {
        this.reservation_type = reservation_type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
