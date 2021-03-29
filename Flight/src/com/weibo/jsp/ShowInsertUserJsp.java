package com.weibo.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    @author weibo
    @date 2021/1/29 - 14:50
*/
@WebServlet(name = "ShowInsertUserJsp",value = {"/manager/safe/ShowInsertUserJsp"})
public class ShowInsertUserJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>新增用户</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println(        "<form action='/Flight/manager/safe/InsertUserController' method='post'>");
        printWriter.println("           用户名:<input type='text' name='user_name'><br>");
        printWriter.println("           用户余额:<input type='text' name='user_balance'><br>");
        printWriter.println("           用户年龄:<input type='text' name='user_age'><br>");
        printWriter.println("           <input type='submit' value='新建'><br>");
        printWriter.println("       </form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
