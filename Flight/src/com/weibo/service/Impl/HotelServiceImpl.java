package com.weibo.service.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:45
*/


import com.weibo.dao.HotelDao;
import com.weibo.dao.Impl.HotelDaoImpl;
import com.weibo.dao.Impl.ReservationDaoImpl;
import com.weibo.dao.ReservationDao;
import com.weibo.entity.Hotel;
import com.weibo.service.HotelService;
import com.weibo.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class HotelServiceImpl implements HotelService {
    private HotelDao hotelDao = new HotelDaoImpl();
    private ReservationDao reservationDao = new ReservationDaoImpl();
    @Override
    public List<Hotel> showAllHotel() {
        List<Hotel> hotels = new ArrayList<>();
        try {
            DbUtils.begin();
            List<Hotel> temps = hotelDao.selectAll();
            if(temps != null){
                hotels = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return hotels;
    }

    @Override
    public int removeHotel(String hotel_name) {
        int result = 0;

        try {
            DbUtils.begin();
            result = hotelDao.delete(hotel_name);
            reservationDao.delete(hotel_name,3);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int modify(Hotel hotel) {
        int result = 0;
        try {
            DbUtils.begin();
            result = hotelDao.update(hotel);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Hotel showHotel(String hotel_name) {
        Hotel hotel  = null;
        try {
            DbUtils.begin();
            hotel = hotelDao.select(hotel_name);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return hotel;
    }

    @Override
    public void add(Hotel hotel) {
        try {
            DbUtils.begin();
            hotelDao.insert(hotel);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
    }
}
