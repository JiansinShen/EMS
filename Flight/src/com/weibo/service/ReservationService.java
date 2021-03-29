package com.weibo.service;/*
    @author weibo
    @date 2021/1/28 - 19:32
*/


import com.weibo.entity.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> showAllReservation();

    public int removeReservation(String reservation_name, int reservation_type);

    public Reservation showReservation(String reservation, int reservation_type);

    public void add(Reservation reservation);
}
