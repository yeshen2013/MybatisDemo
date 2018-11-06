package com.lyyexample.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lyyexample.common.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by liuyangyang on 2018/6/19.
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("请求进入拦截器！"+httpServletRequest.getMethod());
        if(o instanceof ResponseModel){
            ResponseModel responseModel = (ResponseModel)o;
            responseModel.setRetMsg("请求preHandle");
            logger.info(JSONObject.toJSONString(o));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("进入请求处理过程！");
        if(o instanceof ResponseModel){
            ResponseModel responseModel = (ResponseModel)o;
            responseModel.setRetMsg("请求处理过程");
            logger.info(JSONObject.toJSONString(o));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("完成请求："+o.toString());
        if(o instanceof ResponseModel){
            ResponseModel responseModel = (ResponseModel)o;
            responseModel.setRetMsg("请求正确返回");
            logger.info(JSONObject.toJSONString(o));
        }
        logger.info("请求正确返回！"+HttpServletResponse.SC_OK);
    }
}
