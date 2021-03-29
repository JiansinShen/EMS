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
    @date 2021/1/29 - 16:00
*/
@WebServlet(name = "ShowInsertFlightJsp",value = {"/manager/safe/ShowInsertFlightJsp"})
public class ShowInsertFlightJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>新增航班</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println(        "<form action='/Flight/manager/safe/InsertFlightController' method='post'>");
        printWriter.println("           航班号:<input type='text' name='flight_num'><br>");
        printWriter.println("           航班价格:<input type='text' name='flight_price'><br>");
        printWriter.println("           航班总座位数:<input type='text' name='flight_total_seats'><br>");
        printWriter.println("           航班剩余座位数:<input type='text' name='flight_rest_seats'><br>");
        printWriter.println("           航班出发城市:<input type='text' name='flight_from_city'><br>");
        printWriter.println("           航班目的城市:<input type='text' name='flight_to_city'><br>");
        printWriter.println("           <input type='submit' value='新建'><br>");
        printWriter.println("       </form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
