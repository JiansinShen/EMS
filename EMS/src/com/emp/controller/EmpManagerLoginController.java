package com.emp.controller;

import com.emp.entity.EMPMManager;
import com.emp.service.EmpManagerService;
import com.emp.service.Impl.EmpManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/28 - 11:07
*/
//所有与管理员有关的操作，都放在manager目录下面
@WebServlet(name = "EmpManagerLoginController",value = {"/manager/EmpManagerLoginController"})
public class EmpManagerLoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String inputVcode = request.getParameter("inputVcode");

        //2.校验
        String codes = (String)request.getSession().getAttribute("codes");
        if(!inputVcode.isEmpty() && inputVcode.equalsIgnoreCase(codes)){
            //调用业务逻辑实现登录
            EmpManagerService empManagerService = new EmpManagerServiceImpl();
            EMPMManager empManager = empManagerService.login(username, password);
            if(empManager != null){
                //登陆成功
                //存储在session作用域
                HttpSession session = request.getSession();
                session.setAttribute("empManager",empManager);
                //跳转到查询所有的controller
                response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmpController");
            }else{
                response.sendRedirect(request.getContextPath()+"/login.html");
            }
        }else{
            //验证码输入错误，跳转到登陆页面
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
