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
        urlPatterns = "/layui/page/*"

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
        if (session.getAttribute("username") == null) {
            System.err.println("拦截");
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            System.out.println("放行");
            filterChain.doFilter(request, response);
        }
    }
    public void destroy() {
    }
}
