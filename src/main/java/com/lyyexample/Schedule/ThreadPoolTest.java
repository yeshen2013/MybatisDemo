package com.lyyexample.Schedule;

import com.lyyexample.MyThread.DemoThread;
import com.lyyexample.MyThread.TestThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by liuyangyang on 2019/3/3.
 */
@Component
@EnableScheduling
@Slf4j
public class ThreadPoolTest {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

//    @Scheduled(fixedDelay = 20000)
    public void test() throws InterruptedException {
        log.info("ThreadPoolTest开始定时任务！");
        for(int i=0;i<20;i++){
            Future<?> submit = threadPoolExecutor.submit(new DemoThread(i));
            if(submit.isDone()){
                log.info(submit.toString()+"执行成功");
            }
        }
        log.info("ThreadPoolTest定时任务结束");
        Thread.sleep(10000);
    }

//    @Scheduled(fixedDelay = 20000)
    public void test1() throws InterruptedException {
        log.info("ThreadPoolTest开始定时任务！");
        threadPoolExecutor.submit(new DemoThread(1));
        threadPoolExecutor.submit(new DemoThread(2));
        threadPoolExecutor.submit(new TestThread(1));
        threadPoolExecutor.submit(new TestThread(2));
        log.info("ThreadPoolTest定时任务结束");
        Thread.sleep(10000);
    }
}
