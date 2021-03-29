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
    @date 2021/1/29 - 13:05
*/
@WebServlet(name = "ShowUserController",value = {"/manager/safe/ShowUserController"})
public class ShowUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer user_id = Integer.valueOf(request.getParameter("user_id"));

        UserService userService = new UserServiceImpl();
        User user = userService.showUser(user_id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/manager/safe/ShowUpdateUserInfoJsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
