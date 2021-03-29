package com.weibo.service.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:45
*/



import com.weibo.dao.CarDao;
import com.weibo.dao.Impl.CarDaoImpl;
import com.weibo.dao.Impl.ReservationDaoImpl;
import com.weibo.dao.ReservationDao;
import com.weibo.entity.Car;
import com.weibo.service.CarService;
import com.weibo.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private CarDao carDao = new CarDaoImpl();
    private ReservationDao reservationDao = new ReservationDaoImpl();
    @Override
    public List<Car> showAllCar() {
        List<Car> cars = new ArrayList<>();

        try {
            DbUtils.begin();
            List<Car> temps = carDao.selectAll();
            if(temps != null){
                cars = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return cars;
    }

    @Override
    public int removeCar(String city_name) {
        int result = 0;

        try {
            DbUtils.begin();
            result = carDao.delete(city_name);
            reservationDao.delete(city_name, 1);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int modify(Car car) {
        int result = 0;
        try {
            DbUtils.begin();
            result = carDao.update(car);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Car showCar(String city_name) {
        Car car = null;

        try {
            DbUtils.begin();
            car = carDao.select(city_name);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public void add(Car car) {
        try {
            DbUtils.begin();
            carDao.insert(car);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
    }
}
