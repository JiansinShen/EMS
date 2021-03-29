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
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 10:03
*/
@WebServlet(name = "ShowAllCarController",value = {"/manager/safe/showAllCarController"})
public class ShowAllCarController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarService carService = new CarServiceImpl();

        List<Car> cars = carService.showAllCar();
        request.setAttribute("cars", cars);

        request.getRequestDispatcher("/manager/safe/showAllCarJsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
