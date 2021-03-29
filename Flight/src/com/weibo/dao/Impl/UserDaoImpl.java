package com.weibo.dao.Impl;
/*
    @author weibo
    @date 2021/1/28 - 17:10
*/


import com.weibo.dao.UserDao;
import com.weibo.entity.User;
import com.weibo.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<User> selectAll() {
        try {
            List<User> users = queryRunner.query(DbUtils.getConnection(),"select * from tb_user",new BeanListHandler<User>(User.class));
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(),"delete from tb_user where user_id=?;",id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(User user) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "update tb_user set user_name=?,user_balance=?,user_age=? where user_id=?;", user.getUser_name(), user.getUser_balance(), user.getUser_age(), user.getUser_id());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User select(int id) {
        try {
            User user = queryRunner.query(DbUtils.getConnection(),"select* from tb_user where user_id=?;",new BeanHandler<User>(User.class),id);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User select(String user_name) {
        User user = null;

        try {
            String sql = "select* from tb_user where user_name=?;";
            user = queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<User>(User.class), user_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public void insert(User user){
        try{
            String sql = "insert into tb_user(user_name,user_balance,user_age) values(?,?,?)";
            queryRunner.update(DbUtils.getConnection(),sql,user.getUser_name(),user.getUser_balance(),user.getUser_age());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
