package com.weibo.jsp;

import com.weibo.entity.Admin;
import com.weibo.entity.Flight;
import com.weibo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 11:08
*/
@WebServlet(name = "ShowAllFlightJsp",value = {"/manager/safe/showAllFlightJsp"})
public class ShowAllFlightJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Flight> flights = (List<Flight>)request.getAttribute("flights");
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查看所有航班</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("<h3>"+"欢迎您,"+admin.getUsername()+"</h3>");
        printWriter.println("<form action='/Flight/manager/safe/ShowInsertFlightJsp' method='post'>");
        printWriter.println("   <input type='submit' value='插入航班'><br>");
        printWriter.println("</form>");
        printWriter.println("       <table border = '1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>航班号</td>");
        printWriter.println("               <td>航班价格</td>");
        printWriter.println("               <td>航班总座位数</td>");
        printWriter.println("               <td>航班剩余座位数</td>");
        printWriter.println("               <td>出发城市</td>");
        printWriter.println("               <td>目的城市</td>");
        printWriter.println("               <td colspan='2'>操作</td>");
        printWriter.println("           </tr>");
        for(Flight flight:flights){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+flight.getFlight_num()+"</td>");
            printWriter.println("               <td>"+flight.getFlight_price()+"</td>");
            printWriter.println("               <td>"+flight.getFlight_total_seats()+"</td>");
            printWriter.println("               <td>"+flight.getFlight_rest_seats()+"</td>");
            printWriter.println("               <td>"+flight.getFlight_from_city()+"</td>");
            printWriter.println("               <td>"+flight.getFlight_to_city()+"</td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/RemoveFlightController?flight_num="+flight.getFlight_num()+"'>删除</a></td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/ShowFlightController?flight_num="+flight.getFlight_num()+"'>修改</td>");
            printWriter.println("           </tr>");
        }
        printWriter.println("       </table>");
        printWriter.println("       <a href='/Flight/WelcomeAdminMain.html'>返回主页面</a>");
        printWriter.println("   </body>");
        printWriter.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
