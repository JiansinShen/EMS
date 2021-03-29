package com.weibo.dao.Impl;/*
    @author weibo
    @date 2021/1/28 - 18:46
*/

import com.weibo.dao.CarDao;
import com.weibo.entity.Car;
import com.weibo.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CarDaoImpl implements CarDao {
    QueryRunner queryRunner = new QueryRunner();
    @Override
    public List<Car> selectAll() {
        try {
            List<Car> cars = queryRunner.query(DbUtils.getConnection(),"select* from tb_car;",new BeanListHandler<Car>(Car.class));
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(String city_name) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "delete from tb_car where city_name=?;", city_name);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Car car) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "update tb_car set car_total_num=?,car_rest_num=?,car_price=? where city_name=?;", car.getCar_total_num(), car.getCar_rest_num(), car.getCar_price(), car.getCity_name());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void insert(Car car) {
        try{
            String sql = "insert into tb_car values(?,?,?,?);";
            queryRunner.update(DbUtils.getConnection(),sql,car.getCity_name(),car.getCar_total_num(),car.getCar_rest_num(),car.getCar_price());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Car select(String city_name) {
        try {
            Car car = queryRunner.query(DbUtils.getConnection(),"select * from tb_car where city_name=?;",new BeanHandler<Car>(Car.class),city_name);
            return car;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
