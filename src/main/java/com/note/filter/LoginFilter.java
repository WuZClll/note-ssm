package com.note.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
        filterName = "LoginFilter",
        urlPatterns = {"/note/layui/page/*"}

)
public class LoginFilter implements Filter {
    public LoginFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String path = request.getContextPath();
        String url = request.getRequestURI();
        System.err.println(path);
        if (session.getAttribute("user") == null) {
            System.err.println("拦截");
            response.sendRedirect(request.getContextPath() + "/note/layui/login.html");
        } else {
            System.out.println("放行");
            filterChain.doFilter(request, response);
        }

    }
    public void destroy() {
    }
}
