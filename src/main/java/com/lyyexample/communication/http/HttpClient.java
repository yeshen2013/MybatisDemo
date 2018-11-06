package com.lyyexample.communication.http;

import com.alibaba.fastjson.JSONObject;
import com.lyyexample.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by liuyangyang on 2018/8/18.
 */
@Component
public class HttpClient {

    private RestTemplate restTemplate;

    public HttpClient(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setConnectTimeout(60000);
        restTemplateBuilder.setReadTimeout(60000);
        restTemplate = restTemplateBuilder.build();
    }

    public void post(String url,JSONObject request){
        User user = restTemplate.postForObject(url,request, User.class);
    }







}
