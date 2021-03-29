package com.weibo.service;/*
    @author weibo
    @date 2021/1/28 - 19:31
*/


import com.weibo.entity.Hotel;

import java.util.List;

public interface HotelService {
    public List<Hotel> showAllHotel();

    public int removeHotel(String hotel_name);

    public int modify(Hotel hotel);

    public Hotel showHotel(String hotel_name);

    public void add(Hotel hotel);
}
