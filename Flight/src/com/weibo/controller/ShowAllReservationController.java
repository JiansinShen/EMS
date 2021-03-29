package com.weibo.controller;

import com.weibo.entity.Reservation;
import com.weibo.service.Impl.ReservationServiceImpl;
import com.weibo.service.ReservationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 10:04
*/
@WebServlet(name = "ShowAllReservationController",value = {"/manager/safe/showAllReservationController"})
public class ShowAllReservationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationService reservationService = new ReservationServiceImpl();
        List<Reservation> reservations = reservationService.showAllReservation();
        request.setAttribute("reservations",reservations);
        request.getRequestDispatcher("/manager/safe/showAllReservationJsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
