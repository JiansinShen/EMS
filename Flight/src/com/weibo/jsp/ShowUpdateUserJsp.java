package com.weibo.jsp;

import com.weibo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    @author weibo
    @date 2021/1/29 - 13:11
*/
@WebServlet(name = "ShowUpdateUserJsp",value = {"/manager/safe/ShowUpdateUserInfoJsp"})
public class ShowUpdateUserJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getAttribute("user");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset = 'UTF-8'>");
        printWriter.println("       <title>修改用户信息页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <form action='/Flight/manager/safe/UpdateUserController' method='post'>");
        printWriter.println("           用户id:<input type='text' name='user_id' value='"+user.getUser_id()+"' readonly><br>");
        printWriter.println("           用户姓名:<input type='text' name='user_name' value='"+user.getUser_name()+"'><br>");
        printWriter.println("           用户余额:<input type='text' name='user_balance' value='"+user.getUser_balance()+"'><br>");
        printWriter.println("           用户年龄:<input type='text' name='user_age' value='"+user.getUser_age()+"'><br>");
        printWriter.println("           <input type='submit' value='修改'><br>");
        printWriter.println("       <form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
