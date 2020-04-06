package com.family.bbkingweb.shiro;


import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroEncryption {
    /***
     * 对用户的密码进行MD5加密
     * 做成工具类
     */
    public static String shiroEncryption(String password,String salt) {

        // shiro 自带的工具类生成salt
        //String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 加密次数
        int times = 2;
        // 算法名称
        String algorithmName = "md5";

        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();

        // 返回加密后的密码
        return encodedPassword;
    }
}
