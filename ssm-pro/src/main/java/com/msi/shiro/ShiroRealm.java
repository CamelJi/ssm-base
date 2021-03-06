package com.msi.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.msi.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

public class ShiroRealm extends AuthenticatingRealm {


    /**
     * 设置凭证匹配器(认证时会将用户输入密码进行加密然后和数据库查询出密码进行比对)
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher cMatcher= new HashedCredentialsMatcher();
        // 设置加密算法
        cMatcher.setHashAlgorithmName("MD5");
        // 加密次数
        cMatcher.setHashIterations(10);
        super.setCredentialsMatcher(cMatcher);
    }


    /**
     * 执行认证操作时,此方法用户获取用户认证信息
     * 说明:此方法由认证管理器调用
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取客户端提交的用户信息
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.eq("user_name", username);
        //2.基于用户名从数据库查询用户信息
        SysUser user = new SysUser().selectOne(queryWrapper);

        //3.校验用户信息(用户存在吗)
        if(user == null) {
            throw new UnknownAccountException("用户名或密码有误！");
        }
        if(user.getStatus() == 0) {
            throw new UnknownAccountException("用户名已被禁用，请联系系统管理员！");
        }
        //4.对用户信息进行封装
        ByteSource credentialsSalt = ByteSource.Util.bytes(new Md5Hash(user.getSalt()));
        SimpleAuthenticationInfo info=
                new SimpleAuthenticationInfo(
                        //principal(用户身份)
                        user,
                        //hashedCredentials(已经加密的密码)
                        user.getPassword(),
                        //credentialsSalt(盐)
                        credentialsSalt,
                        //realm name
                        getName());
        //此对象返回给谁了?认证管理器
        return info;
    }

}
