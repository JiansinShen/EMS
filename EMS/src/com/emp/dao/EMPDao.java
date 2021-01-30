package com.emp.dao;
/*
    @author weibo
    @date 2021/1/28 - 12:10
*/

import com.emp.entity.EMP;

import java.util.List;

public interface EMPDao {
    public List<EMP> selectAll();

    public int delete(int id);

    public int update(EMP emp);

    public EMP select(int id);
}
