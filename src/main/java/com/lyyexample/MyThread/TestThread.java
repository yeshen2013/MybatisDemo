package com.lyyexample.MyThread;

import com.lyyexample.service.impl.ThreadService;

/**
 * Created by liuyangyang on 2019/3/3.
 */
public class TestThread implements Runnable {

    private int taskNum;

    public TestThread(int taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        try {
//            ThreadService.commonParam();
//            ThreadService.lockDemo();
            ThreadService.reduce();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
