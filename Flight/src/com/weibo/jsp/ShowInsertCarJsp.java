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
@WebServlet(name = "ShowInsertCarJsp",value = {"/manager/safe/ShowInsertCarJsp"})
public class ShowInsertCarJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>新增出租车</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println(        "<form action='/Flight/manager/safe/InsertCarController' method='post'>");
        printWriter.println("           城市名:<input type='text' name='city_name'><br>");
        printWriter.println("           出租车总数:<input type='text' name='car_total_num'><br>");
        printWriter.println("           出租车剩余数:<input type='text' name='car_rest_num'><br>");
        printWriter.println("           出租车价格:<input type='text' name='car_price'><br>");
        printWriter.println("           <input type='submit' value='新建'><br>");
        printWriter.println("       </form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
