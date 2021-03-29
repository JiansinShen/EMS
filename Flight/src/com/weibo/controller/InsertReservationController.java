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

/*
    @author weibo
    @date 2021/1/29 - 15:59
*/
@WebServlet(name = "InsertReservationController",value = {"/manager/safe/InsertReservationController"})
public class InsertReservationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reservation_name = request.getParameter("reservation_name");
        Integer reservation_type = Integer.valueOf(request.getParameter("reservation_type"));
        String user_name = request.getParameter("user_name");
        Reservation reservation = new Reservation(reservation_name,reservation_type,user_name);
        ReservationService reservationService = new ReservationServiceImpl();
        reservationService.add(reservation);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllReservationController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
