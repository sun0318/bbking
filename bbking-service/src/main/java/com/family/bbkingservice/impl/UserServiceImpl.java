package com.family.bbkingservice.impl;

import com.family.bbkingdao.entity.User;
import com.family.bbkingdao.mapper.UserMapper;
import com.family.bbkingservice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Override
    @Cacheable(value = "user", key = "#user.username")
    public List<User> getUserList(@RequestParam("user") User user) {
        log.info("进入getUserList");
        return userMapper.getUserList(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

}
