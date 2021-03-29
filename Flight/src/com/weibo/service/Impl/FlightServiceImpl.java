package com.weibo.service.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:45
*/


import com.weibo.dao.FlightDao;
import com.weibo.dao.Impl.FlightDaoImpl;
import com.weibo.dao.Impl.ReservationDaoImpl;
import com.weibo.dao.ReservationDao;
import com.weibo.entity.Flight;
import com.weibo.service.FlightService;
import com.weibo.utils.DbUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    private FlightDao flightDao = new FlightDaoImpl();
    private ReservationDao reservationDao = new ReservationDaoImpl();

    @Override
    public List<Flight> showAllFlight() {
        List<Flight> flights = new ArrayList<>();

        try {
            DbUtils.begin();
            List<Flight> temps = flightDao.selectAll();
            if(temps != null){
                flights = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public int removeFlight(String flight_num) {
        int result = 0;

        try {
            DbUtils.begin();
            result = flightDao.delete(flight_num);
            reservationDao.delete(flight_num,2);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(Flight flight) {
        int result = 0;

        try {
            DbUtils.begin();
            result = flightDao.update(flight);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Flight showFlight(String flight_num) {
        Flight flight = null;

        try {
            DbUtils.begin();
            flight = flightDao.select(flight_num);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }


        return flight;
    }

    @Override
    public void add(Flight flight) {
        try {
            DbUtils.begin();
            flightDao.insert(flight);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
    }
}
