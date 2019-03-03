package com.lyyexample.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by liuyangyang on 2019/3/3.
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.lyyexample.MyAnnotation.LogAnnotation)")
    public void logPrint(){
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void controllerParam(){
    }

    @Before("logPrint()")
    public void inParam(JoinPoint joinPoint){
        log.info("进入LogAnnotation注解，before！");
    }

    @After("logPrint()")
    public void outParam(){
        log.info("进入LogAnnotation注解！，after！");
    }

    @Before("controllerParam()")
    public void controllerRequest(JoinPoint joinPoint){
        log.info("进入controller注解！，before！");
    }

    @After("controllerParam()")
    public void controllerResponse(){
        log.info("进入controller注解！，after！");
    }

}
