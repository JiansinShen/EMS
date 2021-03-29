package com.weibo.controller;

import com.weibo.service.FlightService;
import com.weibo.service.Impl.FlightServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/29 - 12:06
*/
@WebServlet(name = "RemoveFlightController",value = {"/manager/safe/RemoveFlightController"})
public class RemoveFlightController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flight_num = request.getParameter("flight_num");
        FlightService flightService = new FlightServiceImpl();
        flightService.removeFlight(flight_num);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllFlightController");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
