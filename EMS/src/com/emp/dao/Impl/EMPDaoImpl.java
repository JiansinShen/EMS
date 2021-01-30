package com.emp.dao.Impl;
/*
    @author weibo
    @date 2021/1/28 - 12:11
*/

import com.emp.dao.EMPDao;
import com.emp.entity.EMP;
import com.emp.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EMPDaoImpl implements EMPDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<EMP> selectAll() {
        try {
            List<EMP> emps = queryRunner.query(DbUtils.getConnection(), "select* from emp", new BeanListHandler<EMP>(EMP.class));
            return emps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "delete from emp where id = ?;", id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(EMP emp) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "update emp set name=?,salary=?,age=? where id =?;", emp.getName(), emp.getSalary(), emp.getAge(), emp.getId());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public EMP select(int id) {
        try {
            EMP emp = queryRunner.query(DbUtils.getConnection(), "select * from emp where id = ?;", new BeanHandler<EMP>(EMP.class), id);
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
