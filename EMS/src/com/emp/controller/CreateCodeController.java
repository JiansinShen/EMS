package com.emp.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/28 - 11:11
*/
@WebServlet(name = "CreateCodeController",value = {"/CreateCode"})
public class CreateCodeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成验证码
        ValidateCode validateCode = new ValidateCode(200,20,4,20);
        String codes = validateCode.getCode();
        HttpSession session = request.getSession();
        session.setAttribute("codes",codes);
        validateCode.write(response.getOutputStream());//响应给客户端

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
