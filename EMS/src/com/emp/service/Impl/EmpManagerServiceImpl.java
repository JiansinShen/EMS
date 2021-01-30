package com.emp.service.Impl;
/*
    @author weibo
    @date 2021/1/28 - 11:02
*/

import com.emp.dao.EMPManagerDao;
import com.emp.dao.Impl.EMPManagerDaoImpl;
import com.emp.entity.EMPMManager;
import com.emp.service.EmpManagerService;
import com.emp.utils.DbUtils;

public class EmpManagerServiceImpl implements EmpManagerService {
    private EMPManagerDao empManagerDao = new EMPManagerDaoImpl();
    @Override
    public EMPMManager login(String username, String password) {
        EMPMManager empmManager = null;
        try {
            DbUtils.begin();
            EMPMManager temp = empManagerDao.select(username);//根据empManagerDao查询到EmpManager对象

            if(temp != null){
                //查询到对象
                if(temp.getPassword().equals(password)){
                    empmManager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empmManager;
    }
}
