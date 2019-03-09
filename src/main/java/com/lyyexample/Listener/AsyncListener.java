package com.lyyexample.Listener;

import com.lyyexample.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by liuyangyang on 2019/3/9.
 */
@Component
@EnableAsync
@Slf4j
public class AsyncListener {

    @Async
    @EventListener(MyEvent.class)
    public void listen(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("异步监听！");
    }
}
