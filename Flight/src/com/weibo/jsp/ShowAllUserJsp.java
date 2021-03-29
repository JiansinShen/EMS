package com.weibo.jsp;

import com.weibo.entity.Admin;
import com.weibo.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*
    @author weibo
    @date 2021/1/29 - 10:38
*/
@WebServlet(name = "ShowAllUserJsp",value = {"/manager/safe/showAllUserJsp"})
public class ShowAllUserJsp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取集合数据
        List<User> users = (List<User>)request.getAttribute("users");
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("   <head>");
        printWriter.println("       <meta charset='UTF-8'>");
        printWriter.println("       <title>查看所有用户</title>");
        printWriter.println("   </head>");
        printWriter.println("   <body>");
        printWriter.println("<h3>"+"欢迎您,"+admin.getUsername()+"</h3>");
        printWriter.println("<form action='/Flight/manager/safe/ShowInsertUserJsp' method='post'>");
        printWriter.println("   <input type='submit' value='插入用户'><br>");
        printWriter.println("</form>");

        printWriter.println("       <table border = '1'>");
        printWriter.println("           <tr>");
        printWriter.println("               <td>用户id</td>");
        printWriter.println("               <td>用户名</td>");
        printWriter.println("               <td>用户余额</td>");
        printWriter.println("               <td>用户年龄</td>");
        printWriter.println("               <td colspan='2'>操作</td>");
        printWriter.println("           </tr>");
        for(User user:users){
            printWriter.println("           <tr>");
            printWriter.println("               <td>"+user.getUser_id()+"</td>");
            printWriter.println("               <td>"+user.getUser_name()+"</td>");
            printWriter.println("               <td>"+user.getUser_balance()+"</td>");
            printWriter.println("               <td>"+user.getUser_age()+"</td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/RemoveUserController?user_id="+user.getUser_id()+"'>删除</a></td>");
            printWriter.println("               <td><a href = '"+request.getContextPath()+"/manager/safe/ShowUserController?user_id="+user.getUser_id()+"'>修改</td>");
            printWriter.println("           </tr>");
        }
        printWriter.println("       </table>");
        printWriter.println("   </body>");
        printWriter.println("       <a href='/Flight/WelcomeAdminMain.html'>返回主页面</a>");
        printWriter.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
