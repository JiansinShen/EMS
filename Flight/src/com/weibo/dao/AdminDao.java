package com.weibo.dao;/*
    @author weibo
    @date 2021/1/28 - 17:09
*/

import com.weibo.entity.Admin;

public interface AdminDao {
    public Admin select(String username);
}
