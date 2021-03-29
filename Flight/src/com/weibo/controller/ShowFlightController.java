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
    @date 2021/1/29 - 13:27
*/
@WebServlet(name = "ShowFlightController",value = {"/manager/safe/ShowFlightController"})
public class ShowFlightController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flight_num = request.getParameter("flight_num");

        FlightService flightService = new FlightServiceImpl();
        Flight flight = flightService.showFlight(flight_num);
        request.setAttribute("flight",flight);
        request.getRequestDispatcher("/manager/safe/ShowUpdateFlightInfoJsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
