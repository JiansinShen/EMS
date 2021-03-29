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
@WebServlet(name = "ShowInsertHotelJsp",value = {"/manager/safe/ShowInsertHotelJsp"})
public class ShowInsertHotelJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>新增宾馆</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println(        "<form action='/Flight/manager/safe/InsertHotelController' method='post'>");
        printWriter.println("           宾馆名:<input type='text' name='hotel_name'><br>");
        printWriter.println("           宾馆价格:<input type='text' name='hotel_price'><br>");
        printWriter.println("           宾馆总房间数:<input type='text' name='hotel_total_room'><br>");
        printWriter.println("           宾馆剩余房间数:<input type='text' name='hotel_rest_room'><br>");

        printWriter.println("           <input type='submit' value='新建'><br>");
        printWriter.println("       </form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
