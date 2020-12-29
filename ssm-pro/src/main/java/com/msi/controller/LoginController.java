package com.msi.controller;


import com.msi.entity.SysUser;
import com.msi.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RequestMapping("/login")
@Controller
public class LoginController {


    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value= {"/","/login"})
    public String login() {
        return "pages/login";
    }

    @PostMapping("/login")
    public String login(@RequestBody SysUser user) {
        //使用 shiro 登录验证
        //1 认证的核心组件：获取 Subject 对象
        Subject subject = SecurityUtils.getSubject();
        //2 将登陆表单封装成 token 对象
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            //3 让 shiro 框架进行登录验证：
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
            return "loginError";
        }
        return "redirect:/admin/index";
    }

    @PostMapping("/register")
    public String register(@RequestBody SysUser user) {
        sysUserService.saveSysUser(user);
        return "pages/login";
    }

    @GetMapping("/getUserAll")
    public Map<String, Object> getUserAll() {
        Map<String, Object> result = new HashMap<String, Object>();

        List<SysUser> sysUsers = sysUserService.getUserAll();
        result.put("data", sysUsers);

        return result;
    }

}
