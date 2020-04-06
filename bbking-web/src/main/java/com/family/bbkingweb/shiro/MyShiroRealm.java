package com.family.bbkingweb.shiro;

import com.family.bbkingdao.entity.Permission;
import com.family.bbkingdao.entity.Role;
import com.family.bbkingdao.entity.User;
import com.family.bbkingservice.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        User account = (User) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        User user = loginService.getUserByName(account.getUsername());

        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());
            //添加权限
            for (Permission permission : role.getPermission()) {
                simpleAuthorizationInfo.addStringPermission(permission.getName());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = loginService.getUserByName(token.getUsername());
        String oringnPassword = new String((char[]) token.getCredentials());
        String salt = user.getSalt();
        System.out.println(token.getUsername()+"===="+oringnPassword);
        String encodedPassword = ShiroEncryption.shiroEncryption(oringnPassword,salt);
        System.out.println("密码："+encodedPassword);
        //String password = null;
        // 从数据库获取对应用户名密码的用户
        // usermapperservice.getPasswordByUsername(token.getUsername()).getPassword() --> 获取用户名对应的密码
        if (null == loginService.getUserByName(token.getUsername())) {
            throw new AccountException("用户名不正确");
        } else if (!encodedPassword.equals(user.getPassword())) {
            throw new AccountException("密码不正确");
        }else {
            //password = usermapperservice.getPasswordByUsername(token.getUsername()).getPassword();
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    new SimpleAuthenticationInfo(user,oringnPassword,getName());
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(salt));
            return simpleAuthenticationInfo;
        }
    }
}
