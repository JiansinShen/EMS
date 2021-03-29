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
    @date 2021/1/29 - 13:26
*/
@WebServlet(name = "ShowHotelController",value = {"/manager/safe/ShowHotelController"})
public class ShowHotelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotel_name = request.getParameter("hotel_name");
        HotelService hotelService = new HotelServiceImpl();
        Hotel hotel = hotelService.showHotel(hotel_name);
        request.setAttribute("hotel",hotel);
        request.getRequestDispatcher("/manager/safe/ShowUpdateHotelInfoJsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
