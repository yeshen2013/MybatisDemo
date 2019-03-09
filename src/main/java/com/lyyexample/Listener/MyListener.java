package com.lyyexample.Listener;

import com.alibaba.fastjson.JSONObject;
import com.lyyexample.entry.User;
import com.lyyexample.event.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuyangyang on 2019/3/7.
 */
@Slf4j
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent myEvent) {

        if(myEvent.getSource() instanceof User){
            User user = (User) myEvent.getSource();
            log.info("监听到请求参数："+ JSONObject.toJSONString(user));
        }
        log.info("监听到MyEvent事件，事件信息是："+myEvent.getMsg());
    }
}
