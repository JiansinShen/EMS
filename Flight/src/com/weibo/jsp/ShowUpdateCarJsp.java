package com.weibo.jsp;

import com.weibo.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    @author weibo
    @date 2021/1/29 - 13:30
*/
@WebServlet(name = "ShowUpdateCarJsp",value = {"/manager/safe/ShowUpdateCarInfoJsp"})
public class ShowUpdateCarJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car = (Car)request.getAttribute("car");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>修改出租车信息页面</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <form action='/Flight/manager/safe/UpdateCarController' method='post'>");
        printWriter.println("            城市名:<input type='text' name='city_name' value='"+car.getCity_name()+"' readonly><br>");
        printWriter.println("           出租车总数:<input type='text' name='car_total_num' value='"+car.getCar_total_num()+"'><br>");
        printWriter.println("           出租车剩余数量:<input type='text' name='car_rest_num' value='"+car.getCar_rest_num()+"'><br>");
        printWriter.println("           出租车价格:<input type='text' name='car_price' value='"+car.getCar_price()+"'><br>");
        printWriter.println("           <input type='submit' value='修改'><br>");
        printWriter.println("       <form>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
