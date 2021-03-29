package com.weibo.service;/*
    @author weibo
    @date 2021/1/28 - 19:31
*/


import com.weibo.entity.Car;

import java.util.List;

public interface CarService {
    public List<Car> showAllCar();

    public int removeCar(String city_name);

    public int modify(Car car);

    public Car showCar(String city_name);

    public void add(Car car);
}
