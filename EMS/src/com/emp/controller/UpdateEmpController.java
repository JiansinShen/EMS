package com.emp.controller;

import com.emp.entity.EMP;
import com.emp.service.EMPService;
import com.emp.service.Impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/28 - 14:24
*/
@WebServlet(name = "UpdateEmpController",value = {"/manager/safe/UpdateEmpController"})
public class UpdateEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double salary = Double.valueOf(request.getParameter("salary"));
        Integer age = Integer.valueOf(request.getParameter("age"));

        EMP emp = new EMP(id,name,salary,age);

        EMPService empService = new EmpServiceImpl();
        empService.modify(emp);

        response.sendRedirect(request.getContextPath()+"/manager/safe/showAllEmpController");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
