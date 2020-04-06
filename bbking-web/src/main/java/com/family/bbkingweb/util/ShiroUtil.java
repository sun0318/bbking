package com.family.bbkingweb.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

public class ShiroUtil {
    /**
     * 生成32的随机盐值
     */
    public static String createSalt(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 加盐加密
     * @param srcPwd    原始密码
     * @param saltValue 盐值
     */
    public static String salt(Object srcPwd, String saltValue){
        return new SimpleHash("MD5", srcPwd, saltValue, 1024).toString();
    }
}
