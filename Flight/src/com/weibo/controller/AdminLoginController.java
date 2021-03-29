package com.weibo.controller;


import com.weibo.entity.Admin;
import com.weibo.service.AdminService;
import com.weibo.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/28 - 17:06
*/
@WebServlet(name = "AdminLoginController",value = {"/manager/AdminLoginController"})
public class AdminLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");

        //2.校验
        String codes = (String)request.getSession().getAttribute("codes");
        if(!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)) {
            //调用业务逻辑实现登录
            AdminService adminService = new AdminServiceImpl();
            Admin admin = adminService.login(username,password);
            if(admin != null){
                //登陆成功
                //存储在session作用域
                HttpSession session = request.getSession();
                session.setAttribute("admin",admin);
                //跳转到主欢迎页面
                response.sendRedirect(request.getContextPath()+"/WelcomeAdminMain.html");
            }else{
                response.sendRedirect(request.getContextPath()+"/login.html");
            }

        }else{
            //输入验证码错误，跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
