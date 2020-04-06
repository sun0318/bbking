package com.family.bbkingservice;

import com.family.bbkingdao.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getUserList(User user);
    int addUser(User user);
}
