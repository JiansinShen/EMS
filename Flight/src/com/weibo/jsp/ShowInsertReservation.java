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
    @date 2021/1/29 - 16:01
*/
@WebServlet(name = "ShowInsertReservation",value = {"/manager/safe/ShowInsertReservationJsp"})
public class ShowInsertReservation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>预定</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println(        "<form action='/Flight/manager/safe/InsertReservationController' method='post'>");
        printWriter.println("           预定名:<input type='text' name='reservation_name'><br>");
        printWriter.println("           预定类型:<input type='text' name='reservation_type'><br>");
        printWriter.println("           用户名:<input type='text' name='user_name'><br>");
        printWriter.println("           <input type='submit' value='新建'><br>");
        printWriter.println("       </form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
