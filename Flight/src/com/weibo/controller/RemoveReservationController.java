package com.weibo.controller;

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
    @date 2021/1/29 - 12:07
*/
@WebServlet(name = "RemoveReservationController",value = {"/manager/safe/RemoveReservationController"})
public class RemoveReservationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reservation_name = request.getParameter("reservation_name");
        Integer reservation_type = Integer.valueOf(request.getParameter("reservation_type"));
        ReservationService reservationService = new ReservationServiceImpl();
        reservationService.removeReservation(reservation_name,reservation_type);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllReservationController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
