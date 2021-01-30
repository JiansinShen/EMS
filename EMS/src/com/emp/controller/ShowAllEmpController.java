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
import java.util.List;

/*
    @author weibo
    @date 2021/1/28 - 11:42
*/
@WebServlet(name = "ShowAllEmpController",value = {"/manager/safe/showAllEmpController"})
public class ShowAllEmpController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.权限验证在过滤器中做
        //2.调用业务逻辑
        EMPService empService = new EmpServiceImpl();
        List<EMP> emps = empService.showAllEmp();
        request.setAttribute("emps",emps);
        //转发的形式进行跳转
        request.getRequestDispatcher("/manager/safe/showAllEmpJsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
