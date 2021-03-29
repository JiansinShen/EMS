package com.weibo.controller;

import com.weibo.entity.Hotel;
import com.weibo.service.HotelService;
import com.weibo.service.Impl.HotelServiceImpl;

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
@WebServlet(name = "InsertHotelController",value = {"/manager/safe/InsertHotelController"})
public class InsertHotelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotel_name = request.getParameter("hotel_name");
        Double hotel_price = Double.valueOf(request.getParameter("hotel_price"));
        Integer hotel_total_room = Integer.valueOf(request.getParameter("hotel_total_room"));
        Integer hotel_rest_room = Integer.valueOf(request.getParameter("hotel_rest_room"));
        Hotel hotel = new Hotel(hotel_name,hotel_price,hotel_total_room,hotel_rest_room);
        HotelService hotelService = new HotelServiceImpl();
        hotelService.add(hotel);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllHotelController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
