package com.lyyexample.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyyexample.MyAnnotation.LogAnnotation;
import com.lyyexample.entry.User;
import com.lyyexample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by liuyangyang on 2019/3/2.
 */
@RestController()
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("login")
//    @LogAnnotation
    public ResponseEntity login(@RequestBody @Validated User user, HttpSession httpSession) throws IOException {
        //判断用户是否存在
//        String user = httpServletRequest.getAttribute("user").toString();
//        String passward = httpServletRequest.getAttribute("passward").toString();
//        User login = userMapper.login(user, passward);
        User login = userMapper.login(user.getName(), user.getPassWord());
        if(login != null){
            httpSession.setAttribute("userId", user.getId());
            return ResponseEntity.ok("登陆成功！");
        } else {
            httpSession.setAttribute("userId", "");
            return ResponseEntity.ok("该用户不存在，请先注册");
        }
    }

    @PostMapping("registe")
    public ResponseEntity registe(@RequestBody @Validated User user){
        User check = userMapper.selectByName(user.getName());
        if(check != null){
            user.setCreateTime(new Date());
            boolean add = userMapper.add(user);
            if(add){
                return ResponseEntity.ok("注册成功！");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("注册失败！");
            }
        } else {
            return ResponseEntity.ok("用户名已被注册，请重新注册！");
        }
    }

    @RequestMapping(value = "check", method = RequestMethod.GET)
    public ResponseEntity check(@RequestBody JSONObject jsonObject){
        return null;
    }

}
