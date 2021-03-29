package com.weibo.dao.Impl;/*
    @author weibo
    @date 2021/1/28 - 17:10
*/


import com.weibo.dao.AdminDao;
import com.weibo.entity.Admin;
import com.weibo.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public Admin select(String username) {
        try {
            Admin admin = queryRunner.query(DbUtils.getConnection(), "select * from tb_admin where username=?;", new BeanHandler<Admin>(Admin.class), username);
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
