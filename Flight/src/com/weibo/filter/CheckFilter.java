package com.weibo.filter;

import com.weibo.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
    @author weibo
    @date 2021/1/29 - 10:24
*/
@WebFilter(filterName = "CheckFilter",value = {"/manager/safe/*"})
public class CheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)req;
        HttpServletResponse httpServletResponse = (HttpServletResponse)resp;

        HttpSession session = httpServletRequest.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if(admin != null){
            //登陆过
            chain.doFilter(req, resp);
        }else{
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.html");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
