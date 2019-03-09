package com.lyyexample.controller;

import com.lyyexample.entry.User;
import com.lyyexample.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuyangyang on 2019/3/7.
 */
@RestController
@Slf4j
public class MyPublish {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("publish")
    public ResponseEntity doPublis(@RequestBody User user){
        log.info("接收到发布请求");
        applicationEventPublisher.publishEvent(new MyEvent(user, "发布命令"));
        return ResponseEntity.ok("发布成功！");
    }
}
