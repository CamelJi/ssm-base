package com.msi.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Description 加密 加盐
 */
public class ShiroKit {

    /**
     * 加盐参数
     */
    public static final String HASH_ALGORITHM_NAME = "MD5";

    /**
     * 循环次数 10
     */
    public static final int HASH_ITERATIONS = 10;

    /**
     * shiro密码加密工具类
     *
     * @param credentials 密码
     * @param saltSource 密码盐
     * @return
     */
    public static String md5(String credentials, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(HASH_ALGORITHM_NAME, credentials, salt, HASH_ITERATIONS).toString();
    }

    /**
     * 测试
     * 新增用户时 也使用md5加密 将密文存储在mysql
     * @param args
     */
    public static void main(String[] args) {
        //53a972032dfec8a180c5faa9256888a1
        String password = "123456";
        System.out.println(md5(password,password));
    }

}
