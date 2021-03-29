package com.weibo.dao;/*
    @author weibo
    @date 2021/1/28 - 17:15
*/

import com.weibo.entity.Car;

import java.util.List;

public interface CarDao {
    public List<Car> selectAll();
    public int delete(String city_name);
    public int update(Car car);
    public Car select(String city_name);
    public void insert(Car car);
}
