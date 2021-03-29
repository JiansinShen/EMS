package com.weibo.service;/*
    @author weibo
    @date 2021/1/28 - 19:31
*/


import com.weibo.entity.Admin;

public interface AdminService {
    public Admin login(String username, String password);
}
