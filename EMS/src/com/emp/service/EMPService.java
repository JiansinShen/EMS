package com.emp.service;
/*
    @author weibo
    @date 2021/1/28 - 12:13
*/

import com.emp.entity.EMP;

import java.util.List;

public interface EMPService {
    public List<EMP> showAllEmp();

    public int removeEmp(int id);

    public int modify(EMP emp);

    public EMP showEmp(int id);
}
