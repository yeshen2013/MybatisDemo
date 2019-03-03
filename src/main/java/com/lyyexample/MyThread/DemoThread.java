package com.lyyexample.MyThread;

import com.lyyexample.service.impl.ThreadService;

/**
 * Created by liuyangyang on 2019/3/3.
 */
public class DemoThread implements Runnable {

    @Override
    public void run() {
        try {
//            ThreadService.commonParam();
            ThreadService.lockDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
