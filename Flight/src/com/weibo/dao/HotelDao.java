package com.weibo.dao;/*
    @author weibo
    @date 2021/1/28 - 17:16
*/


import com.weibo.entity.Hotel;

import java.util.List;

public interface HotelDao {
    public List<Hotel> selectAll();

    public Hotel select(String hotel_name);

    public int delete(String hotel_name);

    public int update(Hotel hotel);
    public void insert(Hotel hotel);
}
