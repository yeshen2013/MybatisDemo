package com.lyyexample.Filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liuyangyang on 2019/3/2.
 */
@Configuration
@Order(2)
@Slf4j
public class OtherFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterName = filterConfig.getFilterName();
        log.info(filterName);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入filter2");
        if(servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse){
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
            String method = httpServletRequest.getMethod();
            String requestURI = httpServletRequest.getRequestURI();
            String parameter = httpServletRequest.getParameterMap().toString();
            HttpSession session = httpServletRequest.getSession();
            log.info("请求地址为："+ requestURI+",请求方法为："+ method+",请求参数为："+ parameter);
            if(requestURI.contains("publish")){
                //已登陆不过滤
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
