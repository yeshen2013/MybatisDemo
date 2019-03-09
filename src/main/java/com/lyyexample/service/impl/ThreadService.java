package com.lyyexample.service.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyangyang on 2019/3/3.
 */
@Slf4j
public class ThreadService {


    private static String name="";

    private static int num;

    private static String lockName ="";

    private static int lockNum;

    private static Integer j = 0;

    public static void add() throws InterruptedException {
        synchronized (j){
            ++j;
            System.out.println("加1："+j);
            Thread.sleep(1000);
        }
    }

    public static void reduce() throws InterruptedException {
        synchronized (j){
            --j;
            System.out.println("减1："+j);
            Thread.sleep(1000);
        }
    }

    public static String commonParam() throws InterruptedException {
        synchronized (name){
            ++num;
            name = num+"";
            String threadName = Thread.currentThread().getName();
            log.info("线程"+threadName+"进入commonParam,此时name为："+name);
            Thread.sleep(1000);
        }
        return name;
    }

    public static String lockDemo() throws InterruptedException {
        Lock lock = new ReentrantLock();
        try {
            lock.lock();
            ++lockNum;
            lockName = lockNum+"";
            String threadName = Thread.currentThread().getName();
            log.info("线程"+threadName+"进入lockDemo,此时name为："+lockName);
            Thread.sleep(1000);
            return lockName;
        }catch (Exception e){
            log.error("获取锁异常");
            throw e;
        }finally {
            lock.unlock();
            Thread.sleep(1000);
            log.info("释放锁！");
        }
    }
}
