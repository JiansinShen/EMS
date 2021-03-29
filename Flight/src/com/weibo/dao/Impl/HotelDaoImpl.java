package com.weibo.dao.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:06
*/

import com.weibo.dao.HotelDao;
import com.weibo.entity.Hotel;
import com.weibo.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class HotelDaoImpl implements HotelDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Hotel> selectAll() {
        try {
            List<Hotel> hotels = queryRunner.query(DbUtils.getConnection(),"select* from tb_hotel;",new BeanListHandler<Hotel>(Hotel.class));
            return hotels;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Hotel select(String hotel_name) {
        try {
            Hotel hotel = queryRunner.query(DbUtils.getConnection(),"select* from tb_hotel where hotel_name=?;",new BeanHandler<Hotel>(Hotel.class),hotel_name);
            return hotel;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(String hotel_name) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "delete from tb_hotel where hotel_name=?;", hotel_name);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Hotel hotel) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "update tb_hotel set hotel_price=?,hotel_total_room=?,hotel_rest_room=? where hotel_name=?;", hotel.getHotel_price(), hotel.getHotel_total_room(), hotel.getHotel_rest_room(), hotel.getHotel_name());
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void insert(Hotel hotel) {
        try {
            String sql = "insert into tb_hotel values(?,?,?,?);";
            queryRunner.update(DbUtils.getConnection(),sql,hotel.getHotel_name(),hotel.getHotel_price(),hotel.getHotel_total_room(),hotel.getHotel_rest_room());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
