package com.lyyexample.Listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuyangyang on 2018/11/6.
 */
@Slf4j
@Component
public class ReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.info("&&&&&&&&&&&&&&&&&&&&&&&进入ReadyListener");
    }
}
