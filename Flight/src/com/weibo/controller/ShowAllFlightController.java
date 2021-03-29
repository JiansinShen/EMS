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
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 10:04
*/
@WebServlet(name = "ShowAllFlightController",value = {"/manager/safe/showAllFlightController"})
public class ShowAllFlightController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightService flightService = new FlightServiceImpl();

        List<Flight> flights = flightService.showAllFlight();

        request.setAttribute("flights",flights);

        request.getRequestDispatcher("/manager/safe/showAllFlightJsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
