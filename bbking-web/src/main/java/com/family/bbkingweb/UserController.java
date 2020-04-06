package com.family.bbkingweb;

import com.family.bbkingbase.common.CodeMsg;
import com.family.bbkingdao.entity.User;
import com.family.bbkingservice.UserService;
import com.family.bbkingservice.impl.RedisService;
import com.family.bbkingweb.shiro.ShiroEncryption;
import com.family.bbkingbase.common.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    //注解验角色和权限
    @RequiresRoles("admin")
    //@RequiresPermissions("add")
    @RequestMapping("/getUser")
    @ResponseBody
    public Result getUser(User user) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        List<User> userList = userService.getUserList(user);
        dataMap.put("userList",userList);
        return Result.success(dataMap);
    }

    //注解验角色和权限
    @RequiresRoles("admin")
    //@RequiresPermissions("add")
    @RequestMapping("/addUser")
    public Result addUser(User user) {
        user = postUserInfo(user);
        int i = userService.addUser(user);
        return Result.success();
    }
    @RequestMapping("/testException")
    public void testException() throws Exception {
        throw new Exception("异常测试");
    }

    public User postUserInfo(User user) {
        // shiro 自带的工具类生成salt
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();

        String encodedPassword = ShiroEncryption.shiroEncryption(user.getPassword(),salt);
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        return user;
    }
}
