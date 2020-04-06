package com.family.bbkingdao.mapper;

import com.family.bbkingdao.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList(User user);
    int addUser(User user);
}
