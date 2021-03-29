package com.weibo.controller;

import com.weibo.entity.Car;
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
    @date 2021/1/29 - 13:57
*/
@WebServlet(name = "UpdateCarController",value = {"/manager/safe/UpdateCarController"})
public class UpdateCarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city_name = request.getParameter("city_name");
        Integer car_total_num = Integer.valueOf(request.getParameter("car_total_num"));
        Integer car_rest_num = Integer.valueOf(request.getParameter("car_rest_num"));
        Double car_price = Double.valueOf(request.getParameter("car_price"));
        Car car = new Car(city_name,car_total_num,car_rest_num,car_price);
        CarService carService = new CarServiceImpl();
        carService.modify(car);
        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllCarController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
