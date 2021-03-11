package com.msi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msi.dao.SysUserDao;
import com.msi.entity.SysUser;
import com.msi.service.SysUserService;
import com.msi.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisDemoCotroller {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/redis_set.do")
    @ResponseBody
    public String redisDemoSet01(){

        SysUser user = new SysUser();
        user.setId(111);
        user.setPassword("123456");
        user.setUserName("邬思道");
        redisUtil.set("user1", user);

        Page<SysUser> page = new Page<>(1,3);
        IPage<SysUser> sysUserIPage = sysUserService.selectPageVo(page, "");
        redisUtil.setnx("sysUserIPage", sysUserIPage);


        System.out.println("set redis cache success");

        return "success";
    }

    @RequestMapping(value = "/redis_get.do")
    @ResponseBody
    public String redisDemoGet01() {

        SysUser user = (SysUser) redisUtil.get("user1");
        System.out.println(user);

        return "success";
    }

    @RequestMapping(value = "/redis_del.do")
    @ResponseBody
    public String redisDemoDel01() {

        redisUtil.del("user1");
        System.out.println("delete redis cache success...");

        return "success";
    }
}
