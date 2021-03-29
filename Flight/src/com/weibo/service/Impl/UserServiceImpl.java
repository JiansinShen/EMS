package com.weibo.service.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:45
*/


import com.weibo.dao.Impl.ReservationDaoImpl;
import com.weibo.dao.Impl.UserDaoImpl;
import com.weibo.dao.ReservationDao;
import com.weibo.dao.UserDao;
import com.weibo.entity.User;
import com.weibo.service.UserService;
import com.weibo.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private ReservationDao reservationDao = new ReservationDaoImpl();
    @Override
    public List<User> showAllUser() {
        List<User> users = new ArrayList<>();

        try {
            DbUtils.begin();
            List<User> temps = userDao.selectAll();
            if(temps != null){
                users = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public int remove(int id) {
        int result = 0;

        try {
            DbUtils.begin();
            result = userDao.delete(id);
        //    reservationDao.delete(String.valueOf(id),4);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(User user) {
        int result = 0;
        try {
            DbUtils.begin();
            result = userDao.update(user);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User showUser(int id) {
        User user = null;
        try {
            DbUtils.begin();
            user = userDao.select(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void add(User user) {
        try {
            DbUtils.begin();
            userDao.insert(user);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
    }
}
