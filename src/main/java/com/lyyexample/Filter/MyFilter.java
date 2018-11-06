package com.lyyexample.Filter;


import com.lyyexample.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liuyangyang on 2018/9/15.
 */
@Slf4j
@Configuration
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入filter");
        if(servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse){
            HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
            HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
            String method = httpServletRequest.getMethod();
            String contextPath = httpServletRequest.getContextPath();
            String remoteUser = httpServletRequest.getRemoteUser();
            String requestURI = httpServletRequest.getRequestURI();
            HttpSession session = httpServletRequest.getSession();
            String remoteAddr = httpServletRequest.getRemoteAddr();
            String remoteHost = httpServletRequest.getRemoteHost();
            int remotePort = httpServletRequest.getRemotePort();
            log.info("请求"+method+","+contextPath+","+requestURI+","+remoteAddr+","+remoteHost);
            if(requestURI.contains("login")){
                httpServletResponse.sendRedirect("login.html");
            } else {
                filterChain.doFilter(servletRequest,servletResponse);
            }

        }
    }

    @Override
    public void destroy() {

    }
}
