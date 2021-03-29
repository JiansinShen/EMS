package com.weibo.controller;

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
    @date 2021/1/29 - 11:33
*/
@WebServlet(name = "RemoveUserController",value = {"/manager/safe/RemoveUserController"})
public class RemoveUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer user_id = Integer.valueOf(request.getParameter("user_id"));

        UserService userService = new UserServiceImpl();

        userService.remove(user_id);
        response.sendRedirect(request.getContextPath()+"/manager/safe/shoAllUserController");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
