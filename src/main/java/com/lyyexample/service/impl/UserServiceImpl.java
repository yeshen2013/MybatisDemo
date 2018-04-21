package com.lyyexample.service.impl;


import com.lyyexample.entry.User;
import com.lyyexample.mapper.UserMapper;
import com.lyyexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuyangyang on 2018/4/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String name) {
        User userInfo = userMapper.selectByName(name);
        return userInfo;
    }

    @Override
    public List<User> getAll() {
        List<User> all = userMapper.selectAll();
        return all;
    }

    @Override
    public boolean add(User user) {
        return userMapper.add(user);
    }

    @Override
    public boolean modifyById(User user) {
        return userMapper.modifyById(user);
    }

    @Override
    public boolean deleteByName(String name) {
        return userMapper.deleteByName(name);
    }

    @Override
    public boolean deleteById(int id) {
        return userMapper.deleteById(id);
    }
}
