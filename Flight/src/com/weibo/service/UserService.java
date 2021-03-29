package com.weibo.service;
/*
    @author weibo
    @date 2021/1/28 - 19:30
*/

import com.weibo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> showAllUser();

    public int remove(int id);

    public int modify(User user);

    public User showUser(int id);

    public void add(User user);
}
