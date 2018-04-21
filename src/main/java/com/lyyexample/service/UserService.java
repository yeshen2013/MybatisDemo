package com.lyyexample.service;


import com.lyyexample.entry.User;

import java.util.List;

/**
 * Created by liuyangyang on 2018/4/15.
 */
public interface UserService {

    public User getByName(String name);

    public List<User> getAll();

    public boolean add(User user);

    public boolean modifyById(User user);

    public boolean deleteByName(String name);

    public boolean deleteById(int id);
}
