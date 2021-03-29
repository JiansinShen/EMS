package com.weibo.entity;
/*
    @author weibo
    @date 2021/1/28 - 15:37
*/

public class User {
    private int user_id;
    private String user_name;
    private double user_balance;
    private int user_age;

    public User() {

    }

    public User(int user_id, String user_name, double user_balance, int user_age) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_balance = user_balance;
        this.user_age = user_age;
    }

    public User(String user_name, double user_balance, int user_age) {
        this.user_id = 0;
        this.user_name = user_name;
        this.user_balance = user_balance;
        this.user_age = user_age;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_balance=" + user_balance +
                ", user_age=" + user_age +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public double getUser_balance() {
        return user_balance;
    }

    public void setUser_balance(double user_balance) {
        this.user_balance = user_balance;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }
}
