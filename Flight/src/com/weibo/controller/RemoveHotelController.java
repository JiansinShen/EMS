package com.weibo.controller;

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
    @date 2021/1/29 - 12:07
*/
@WebServlet(name = "RemoveHotelController",value = {"/manager/safe/RemoveHotelController"})
public class RemoveHotelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hotel_name = request.getParameter("hotel_name");
        HotelService hotelService = new HotelServiceImpl();
        hotelService.removeHotel(hotel_name);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllHotelsJsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
