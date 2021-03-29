package com.weibo.jsp;

import com.weibo.dao.FlightDao;
import com.weibo.dao.Impl.FlightDaoImpl;
import com.weibo.entity.Admin;
import com.weibo.entity.Flight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 19:06
*/
@WebServlet(name = "ShowUserRouteJsp",value = {"/manager/safe/ShowUserRouteJsp"})
public class ShowUserRouteJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.收参
        String username = request.getParameter("search");

        FlightDao flightDao = new FlightDaoImpl();
        List<Flight> flights = flightDao.selectRoute(username);

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查看"+username+"行程</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("       <table border = '1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>航班号</td>");
        printWriter.println("               <td>出发城市</td>");
        printWriter.println("               <td>目的城市</td>");
        printWriter.println("           </tr>");
        for(Flight flight:flights){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+flight.getFlight_num()+"</td>");
            printWriter.println("               <td>"+flight.getFlight_from_city()+"</td>");
            printWriter.println("               <td>"+flight.getFlight_to_city()+"</td>");
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
