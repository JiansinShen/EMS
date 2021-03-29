package com.weibo.jsp;

import com.weibo.entity.Admin;
import com.weibo.entity.Reservation;
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
    @date 2021/1/29 - 11:16
*/
@WebServlet(name = "ShowAllReservationJsp",value = {"/manager/safe/showAllReservationJsp"})
public class ShowAllReservationJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reservation> reservations = (List<Reservation>)request.getAttribute("reservations");
        Admin admin = (Admin)request.getSession().getAttribute("admin");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查看所有预定信息</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("<h3>"+"欢迎您,"+admin.getUsername()+"</h3>");
        printWriter.println("<form action='/Flight/manager/safe/ShowInsertReservationJsp' method='post'>");
        printWriter.println("   <input type='submit' value='预定'><br>");
        printWriter.println("</form>");
        printWriter.println("<form action='/Flight/manager/safe/ShowUserRouteJsp' method='post'>");
        printWriter.println("   <input type='text' name='search'>");
        printWriter.println("   <input type='submit' value='搜索'><br>");
        printWriter.println("</form>");
        printWriter.println("       <table border = '1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>预定号</td>");
        printWriter.println("               <td>预定类型</td>");
        printWriter.println("               <td>预定用户</td>");
        printWriter.println("               <td>操作</td>");
        printWriter.println("           </tr>");
        for(Reservation reservation:reservations){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+reservation.getReservation_name()+"</td>");
            printWriter.println("               <td>"+reservation.getReservation_type()+"</td>");
            printWriter.println("               <td>"+reservation.getUser_name()+"</td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/RemoveReservationController?reservation_name="+reservation.getReservation_name()+"&reservation_type="+reservation.getReservation_type()+"'>删除</a></td>");
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
