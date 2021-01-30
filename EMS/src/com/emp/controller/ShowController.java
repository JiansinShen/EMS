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
    @date 2021/1/28 - 13:59
*/
@WebServlet(name = "ShowController",value = {"/manager/safe/ShowEmpController"})
public class ShowController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));

        EMPService empService = new EmpServiceImpl();
        EMP emp = empService.showEmp(id);
        request.setAttribute("emp",emp);

        request.getRequestDispatcher("/manager/safe/showUpdateEmpInfoJsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
