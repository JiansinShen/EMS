package com.weibo.dao;/*
    @author weibo
    @date 2021/1/28 - 17:09
*/


import com.weibo.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> selectAll();
    public int delete(int id);
    public int update(User user);
    public User select(int id);
    public void insert(User user);

    public User select(String user_name);
}
