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
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 10:04
*/
@WebServlet(name = "ShowAllHotelController",value = {"/manager/safe/showAllHotelController"})
public class ShowAllHotelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HotelService hotelService = new HotelServiceImpl();
        List<Hotel> hotels = hotelService.showAllHotel();
        request.setAttribute("hotels",hotels);
        request.getRequestDispatcher("/manager/safe/showAllHotelsJsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
