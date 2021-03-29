package com.weibo.dao;/*
    @author weibo
    @date 2021/1/28 - 17:15
*/


import com.weibo.entity.Flight;

import java.util.Date;
import java.util.List;

public interface FlightDao {
    public List<Flight> selectAll();
    public int delete(String flight_num);
    public int update(Flight flight);
    public Flight select(String flight_num);
    public void insert(Flight flight);

    public List<Flight> selectRoute(String username);

}
