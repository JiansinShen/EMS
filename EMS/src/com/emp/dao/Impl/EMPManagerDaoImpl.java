package com.emp.dao.Impl;
/*
    @author weibo
    @date 2021/1/28 - 10:48
*/

import com.emp.dao.EMPManagerDao;
import com.emp.entity.EMPMManager;
import com.emp.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EMPManagerDaoImpl implements EMPManagerDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public EMPMManager select(String username) {
        try {
            //得到一个EMPManager类型对象
            EMPMManager empmManager = (EMPMManager)queryRunner.query(DbUtils.getConnection(), "select* from empmanager where username = ?;", new BeanHandler<EMPMManager>(EMPMManager.class), username);
            return empmManager;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
