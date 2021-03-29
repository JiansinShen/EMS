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
    @date 2021/1/29 - 13:26
*/
@WebServlet(name = "ShowCarController",value = {"/manager/safe/ShowCarController"})
public class ShowCarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city_name = request.getParameter("city_name");
        CarService carService = new CarServiceImpl();
        Car car = carService.showCar(city_name);
        request.setAttribute("car",car);
        request.getRequestDispatcher("/manager/safe/ShowUpdateCarInfoJsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
