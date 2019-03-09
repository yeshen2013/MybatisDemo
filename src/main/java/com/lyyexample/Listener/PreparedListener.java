package com.lyyexample.Listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuyangyang on 2018/11/6.
 */
@Slf4j
@Component
public class PreparedListener implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        log.info("$$$$$$$$$$$$$$$$$$$$进入PreparedListener");
    }
}
