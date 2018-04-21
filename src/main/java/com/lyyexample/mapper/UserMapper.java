package com.lyyexample.mapper;

import com.lyyexample.entry.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by liuyangyang on 2018/4/15.
 */
@Component(value = "userMapper")
public interface UserMapper {

    User selectByName(String name);

    List<User> selectAll();

    boolean add(User user);

    boolean modifyById(User user);

    boolean deleteById(@Param("id") int id);

    boolean deleteByName(@Param("name") String name);
}
