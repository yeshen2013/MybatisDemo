package com.lyyexample.interceptor;

import com.lyyexample.entry.User;
import com.lyyexample.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by liuyangyang on 2019/3/9.
 */
@Component
@Slf4j
public class MyInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求进入MyInterceptor拦截器！");
        boolean flag = true;
        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null) {
            String name = request.getParameter("name");
            String passWord = request.getParameter("passWord");
            User login = userMapper.login(name, passWord);
            if(login == null){
                flag = false;
                response.sendRedirect("login.html");
            }
        }
        return flag;
    }
}
