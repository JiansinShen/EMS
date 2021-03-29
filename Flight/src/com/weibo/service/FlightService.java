package com.weibo.service;/*
    @author weibo
    @date 2021/1/28 - 19:31
*/


import com.weibo.entity.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {
    public List<Flight> showAllFlight();

    public int removeFlight(String flight_num);

    public int modify(Flight flight);

    public Flight showFlight(String flight_num);

    public void add(Flight flight);
}
