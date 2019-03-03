package com.lyyexample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * Created by liuyangyang on 2019/3/3.
 */
@Configuration
public class ThreadPoolConfig {

    @Value("${thread.pool.core.size:5}")
    private int corePoolSize;

    @Value("${thread.pool.maximumPoolSize:10}")
    private int maximumPoolSize;

    @Value("${thread.pool.keepAliveTime:200}")
    private int keepAliveTime;

    @Value("${thread.pool.arrayBlockingQueue:13}")
    private int arrayBlockingQueue;

    @Bean
    public ThreadPoolExecutor initThreadPool(){
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(arrayBlockingQueue));
        threadPool.allowCoreThreadTimeOut(false);
        return threadPool;

    }
}
