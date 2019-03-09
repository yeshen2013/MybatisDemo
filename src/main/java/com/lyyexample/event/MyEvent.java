package com.lyyexample.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by liuyangyang on 2019/3/7.
 */
public class MyEvent extends ApplicationEvent {

    private String msg;

    public MyEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
