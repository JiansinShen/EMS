package com.weibo.jsp;

import com.weibo.entity.Admin;
import com.weibo.entity.Hotel;
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
    @date 2021/1/29 - 11:13
*/
@WebServlet(name = "ShowAllHotelJsp",value = {"/manager/safe/showAllHotelsJsp"})
public class ShowAllHotelJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Hotel> hotels = (List<Hotel>)request.getAttribute("hotels");
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查看所有宾馆</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("<h3>"+"欢迎您,"+admin.getUsername()+"</h3>");
        printWriter.println("<form action='/Flight/manager/safe/ShowInsertHotelJsp' method='post'>");
        printWriter.println("   <input type='submit' value='插入宾馆'><br>");
        printWriter.println("</form>");
        printWriter.println("       <table border = '1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>宾馆名</td>");
        printWriter.println("               <td>宾馆价格</td>");
        printWriter.println("               <td>宾馆总房间数</td>");
        printWriter.println("               <td>宾馆剩余房间数</td>");
        printWriter.println("               <td colspan='2'>操作</td>");
        printWriter.println("           </tr>");
        for(Hotel hotel:hotels){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+hotel.getHotel_name()+"</td>");
            printWriter.println("               <td>"+hotel.getHotel_price()+"</td>");
            printWriter.println("               <td>"+hotel.getHotel_total_room()+"</td>");
            printWriter.println("               <td>"+hotel.getHotel_rest_room()+"</td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/RemoveHotelController?hotel_name="+hotel.getHotel_name()+"'>删除</a></td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/ShowHotelController?hotel_name="+hotel.getHotel_name()+"'>修改</td>");
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
