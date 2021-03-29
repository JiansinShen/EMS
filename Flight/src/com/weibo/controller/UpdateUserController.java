package com.weibo.controller;

import com.weibo.entity.User;
import com.weibo.service.Impl.UserServiceImpl;
import com.weibo.service.UserService;

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
@WebServlet(name = "UpdateUserController",value = {"/manager/safe/UpdateUserController"})
public class UpdateUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        Integer user_id = Integer.valueOf(request.getParameter("user_id"));
        String user_name = request.getParameter("user_name");
        Double user_balance = Double.valueOf(request.getParameter("user_balance"));
        Integer user_age = Integer.valueOf(request.getParameter("user_age"));

        User user = new User(user_id,user_name,user_balance,user_age);
        UserService userService = new UserServiceImpl();
        userService.modify(user);
        response.sendRedirect(request.getContextPath()+"/manager/safe/shoAllUserController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
