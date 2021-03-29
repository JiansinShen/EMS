package com.weibo.service.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:42
*/


import com.weibo.dao.AdminDao;
import com.weibo.dao.Impl.AdminDaoImpl;
import com.weibo.entity.Admin;
import com.weibo.service.AdminService;
import com.weibo.utils.DbUtils;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {
        Admin admin = null;

        try {
            DbUtils.begin();
            Admin temp = adminDao.select(username);
            if(temp != null){
                //查询到对象
                if(temp.getPassword().equals(password)){
                    admin = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return admin;
    }
}
