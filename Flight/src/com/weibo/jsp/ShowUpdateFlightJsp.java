package com.weibo.jsp;

import com.weibo.entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    @author weibo
    @date 2021/1/29 - 13:34
*/
@WebServlet(name = "ShowUpdateFlightJsp",value = {"/manager/safe/ShowUpdateFlightInfoJsp"})
public class ShowUpdateFlightJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Flight flight = (Flight)request.getAttribute("flight");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset = 'UTF-8'>");
        printWriter.println("       <title>修改航班信息页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <form action='/Flight/manager/safe/UpdateFlightController' method='post'>");
        printWriter.println("           航班号:<input type='text' name='flight_num' value='"+flight.getFlight_num()+"' readonly><br>");
        printWriter.println("           航班价格:<input type='text' name='flight_price' value='"+flight.getFlight_price()+"'><br>");
        printWriter.println("           航班总座位数:<input type='text' name='flight_total_seats' value='"+flight.getFlight_total_seats()+"'><br>");
        printWriter.println("           航班剩余座位数:<input type='text' name='flight_rest_seats' value='"+flight.getFlight_rest_seats()+"'><br>");
        printWriter.println("           出发城市:<input type='text' name='flight_from_city' value='"+flight.getFlight_from_city()+"'><br>");
        printWriter.println("           目的城市:<input type='text' name='flight_to_city' value='"+flight.getFlight_to_city()+"'><br>");
        printWriter.println("           <input type='submit' value='修改'><br>");
        printWriter.println("       <form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
