package com.emp.entity;
/*
    @author weibo
    @date 2021/1/28 - 10:45
*/

public class EMPMManager {
    private String username;
    private String password;

    public EMPMManager() {
    }

    public EMPMManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "EMPMManager{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
