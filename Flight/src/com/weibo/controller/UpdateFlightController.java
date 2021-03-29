package com.weibo.controller;

import com.weibo.entity.Flight;
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
    @date 2021/1/29 - 13:58
*/
@WebServlet(name = "UpdateFlightController",value = {"/manager/safe/UpdateFlightController"})
public class UpdateFlightController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flight_num = request.getParameter("flight_num");
        Double flight_price = Double.valueOf(request.getParameter("flight_price"));
        Integer flight_total_seats = Integer.valueOf(request.getParameter("flight_total_seats"));
        Integer flight_rest_seats = Integer.valueOf(request.getParameter("flight_rest_seats"));
        String flight_from_city = request.getParameter("flight_from_city");
        String flight_to_city = request.getParameter("flight_to_city");
        Flight flight = new Flight(flight_num,flight_price,flight_total_seats,flight_rest_seats,flight_from_city,flight_to_city);
        FlightService flightService = new FlightServiceImpl();
        flightService.modify(flight);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllFlightController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
