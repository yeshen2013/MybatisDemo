package com.lyyexample.Schedule;

import com.lyyexample.MyThread.DemoThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liuyangyang on 2019/3/3.
 */
@EnableScheduling
@Component
@Slf4j
public class FixJog {

    @Scheduled(fixedDelay = 20000)
    private void job(){
        log.info("开始定时任务！");
        for(int i=0;i<20;i++){
            new Thread(new DemoThread()).start();
        }
        log.info("定时任务结束");
    }
}
