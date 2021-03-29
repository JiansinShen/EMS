package com.weibo.controller;

import com.weibo.service.CarService;
import com.weibo.service.Impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/29 - 12:01
*/
@WebServlet(name = "RemoveCarController",value = {"/manager/safe/RemoveCarController"})
public class RemoveCarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city_name = request.getParameter("city_name");
        CarService carService = new CarServiceImpl();
        carService.removeCar(city_name);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllCarController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
