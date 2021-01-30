package com.emp.service.Impl;
/*
    @author weibo
    @date 2021/1/28 - 12:14
*/

import com.emp.dao.EMPDao;
import com.emp.dao.Impl.EMPDaoImpl;
import com.emp.entity.EMP;
import com.emp.service.EMPService;
import com.emp.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EMPService {
    private EMPDao empDao = new EMPDaoImpl();

    @Override
    public List<EMP> showAllEmp() {
        List<EMP> emps = new ArrayList<>();

        try {
            DbUtils.begin();
            List<EMP> temps = empDao.selectAll();
            if(temps != null){
                emps = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public int removeEmp(int id) {
        int result = 0;

        try {
            DbUtils.begin();
            result = empDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(EMP emp) {
        int result = 0;

        try {
            DbUtils.begin();
            result = empDao.update(emp);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public EMP showEmp(int id) {
        EMP emp = null;

        try {
            DbUtils.begin();
            emp = empDao.select(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emp;
    }
}
