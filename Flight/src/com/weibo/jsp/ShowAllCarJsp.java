package com.weibo.jsp;

import com.weibo.entity.Admin;
import com.weibo.entity.Car;

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
    @date 2021/1/29 - 11:04
*/
@WebServlet(name = "ShowAllCarJsp",value = {"/manager/safe/showAllCarJsp"})
public class ShowAllCarJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> cars = (List<Car>)request.getAttribute("cars");
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查看所有出租车</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("<h3>"+"欢迎您,"+admin.getUsername()+"</h3>");
        printWriter.println("<form action='/Flight/manager/safe/ShowInsertCarJsp' method='post'>");
        printWriter.println("   <input type='submit' value='插入出租车'><br>");
        printWriter.println("</form>");
        printWriter.println("       <table border = '1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>城市名</td>");
        printWriter.println("               <td>出租车总数量</td>");
        printWriter.println("               <td>出租车剩余数量</td>");
        printWriter.println("               <td>出租车价格</td>");
        printWriter.println("               <td colspan='2'>操作</td>");
        printWriter.println("           </tr>");
        for(Car car:cars){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+car.getCity_name()+"</td>");
            printWriter.println("               <td>"+car.getCar_total_num()+"</td>");
            printWriter.println("               <td>"+car.getCar_rest_num()+"</td>");
            printWriter.println("               <td>"+car.getCar_price()+"</td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/RemoveCarController?city_name="+car.getCity_name()+"'>删除</a></td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/ShowCarController?city_name="+car.getCity_name()+"'>修改</td>");
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
