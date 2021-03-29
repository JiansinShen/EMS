package com.weibo.dao;/*
    @author weibo
    @date 2021/1/28 - 17:16
*/


import com.weibo.entity.Reservation;

import java.util.List;

public interface ReservationDao {
    public List<Reservation> selectAll();

    public Reservation select(String reservation_name, int reservation_type);

    public int update(Reservation reservation);

    public int delete(String reservation_name, int reservation_type);

    public void insert(Reservation reservation);


}
