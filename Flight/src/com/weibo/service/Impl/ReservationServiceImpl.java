package com.weibo.service.Impl;/*
    @author weibo
    @date 2021/1/28 - 19:45
*/


import com.weibo.dao.*;
import com.weibo.dao.Impl.*;
import com.weibo.entity.*;
import com.weibo.service.*;
import com.weibo.utils.DbUtils;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private ReservationDao reservationDao = new ReservationDaoImpl();
    CarDao carDao = new CarDaoImpl();
    FlightDao flightDao = new FlightDaoImpl();
    HotelDao hotelDao = new HotelDaoImpl();

    @Override
    public List<Reservation> showAllReservation() {
        List<Reservation> reservations = new ArrayList<>();

        try {
            DbUtils.begin();
            List<Reservation> temps = reservationDao.selectAll();
            if(temps != null){
                reservations = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return reservations;
    }

    @Override
    public int removeReservation(String reservation_name, int reservation_type) {
        int result = 0;
        try {
            DbUtils.begin();
            result = reservationDao.delete(reservation_name,reservation_type);
            if(reservation_type == 1){
                Car car = carDao.select(reservation_name);
                car.setCar_rest_num(car.getCar_rest_num()+1);
                carDao.update(car);
            }else if(reservation_type == 2){
                Flight flight = flightDao.select(reservation_name);
                flight.setFlight_rest_seats(flight.getFlight_rest_seats()+1);
                flightDao.update(flight);
            }else if(reservation_type == 3){
                Hotel hotel = hotelDao.select(reservation_name);
                hotel.setHotel_rest_room(hotel.getHotel_rest_room()+1);
                hotelDao.update(hotel);
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void add(Reservation reservation) {
        try {
            DbUtils.begin();
            int type = reservation.getReservation_type();
            String reservation_name = reservation.getReservation_name();
            String username = reservation.getUser_name();

            UserService userService = new UserServiceImpl();
            UserDao userDao = new UserDaoImpl();
            User user = userDao.select(username);
            System.out.println("zhiqian");
            if(type == 1){
                CarService carService = new CarServiceImpl();
                Car car1 = carService.showCar(reservation_name);
                carService.modify(new Car(car1.getCity_name(),car1.getCar_total_num(),car1.getCar_rest_num()-1,car1.getCar_price()));

                userService.modify(new User(user.getUser_id(),user.getUser_name(),user.getUser_balance()-car1.getCar_price(),user.getUser_age()));
                System.out.println("11111111111");
                reservationDao.insert(reservation);
            }else if(type == 2){
                FlightService flightService = new FlightServiceImpl();
                Flight flight = flightService.showFlight(reservation_name);
                flightService.modify(new Flight(flight.getFlight_num(), flight.getFlight_price(), flight.getFlight_total_seats(), flight.getFlight_rest_seats()-1, flight.getFlight_from_city(), flight.getFlight_to_city()));
                System.out.println("222222222");
                userService.modify(new User(user.getUser_id(),user.getUser_name(),user.getUser_balance()-flight.getFlight_price(),user.getUser_age()));
                reservationDao.insert(reservation);
            }else if(type == 3){
                HotelService hotelService = new HotelServiceImpl();
                Hotel hotel = hotelService.showHotel(reservation_name);
                hotelService.modify(new Hotel(hotel.getHotel_name(),hotel.getHotel_price(),hotel.getHotel_total_room(),hotel.getHotel_rest_room()-1));

                System.out.println("333333333333");
                userService.modify(new User(user.getUser_id(),user.getUser_name(),user.getUser_balance()-hotel.getHotel_price(),user.getUser_age()));

                reservationDao.insert(reservation);
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return;
    }

    @Override
    public Reservation showReservation(String reservation_name, int reservation_type) {
        Reservation reservation = null;
        try {
            DbUtils.begin();
            reservation = reservationDao.select(reservation_name,reservation_type);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }

        return reservation;
    }
}
