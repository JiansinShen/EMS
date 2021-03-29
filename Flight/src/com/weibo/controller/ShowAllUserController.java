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
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 9:32
*/
@WebServlet(name = "ShowAllUserController",value = {"/manager/safe/shoAllUserController"})
public class ShowAllUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("登陆成功，查询所有");
        //1.权限验证!在过滤器中做
        UserService userService = new UserServiceImpl();
        List<User> users = userService.showAllUser();
        request.setAttribute("users",users);

        request.getRequestDispatcher("/manager/safe/showAllUserJsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
