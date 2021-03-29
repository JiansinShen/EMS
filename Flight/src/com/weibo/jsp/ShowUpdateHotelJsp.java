package com.weibo.jsp;

import com.weibo.entity.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    @author weibo
    @date 2021/1/29 - 13:39
*/
@WebServlet(name = "ShowUpdateHotelJsp",value = {"/manager/safe/ShowUpdateHotelInfoJsp"})
public class ShowUpdateHotelJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel hotel = (Hotel)request.getAttribute("hotel");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset = 'UTF-8'>");
        printWriter.println("       <title>修改宾馆信息页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <form action='/Flight/manager/safe/UpdateHotelController' method='post'>");
        printWriter.println("           宾馆名:<input type='text' name='hotel_name' value='"+hotel.getHotel_name()+"' readonly><br>");
        printWriter.println("           宾馆价格:<input type='text' name='hotel_price' value='"+hotel.getHotel_price()+"'><br>");
        printWriter.println("           宾馆总房间数:<input type='text' name='hotel_total_room' value='"+hotel.getHotel_total_room()+"'><br>");
        printWriter.println("           宾馆剩余房间数:<input type='text' name='hotel_rest_room' value='"+hotel.getHotel_rest_room()+"'><br>");
        printWriter.println("           <input type='submit' value='修改'><br>");
        printWriter.println("       <form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
