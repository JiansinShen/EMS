package com.emp.filter;

import com.emp.entity.EMPMManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/28 - 12:21
*/
@WebFilter(filterName = "CheckFilter",value = {"/manager/safe/*"})
public class CheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.向下转型
        HttpServletRequest servletRequest = (HttpServletRequest)req;
        HttpServletResponse servletResponse = (HttpServletResponse)resp;

        //拿到登录之后存储的对象
        HttpSession session = servletRequest.getSession();
        EMPMManager empManager = (EMPMManager)session.getAttribute("empManager");

        if(empManager != null){
            //证明登录过
            chain.doFilter(req, resp);
        }else{
            servletResponse.sendRedirect(servletRequest.getContextPath()+"/login.html");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
