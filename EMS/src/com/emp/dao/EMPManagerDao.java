package com.emp.dao;
/*
    @author weibo
    @date 2021/1/28 - 10:47
*/

import com.emp.entity.EMPMManager;

public interface EMPManagerDao {
    public EMPMManager select(String username);
}
