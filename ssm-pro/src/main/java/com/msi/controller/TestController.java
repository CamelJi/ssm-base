package com.msi.controller;

import com.msi.entity.User;
import com.msi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/testMethod.do")
    public String testMethod() {
        System.out.println("123");
        return "testMethod";
    }

    @RequestMapping("/findUserList.do")
    @ResponseBody
    public Map<String, Object> findUserList(User user) {
        Map<String, Object> result = new HashMap<String, Object>();

        List<User> userList = userService.findUserList(user);
        result.put("data", userList);

        return result;
    }
}

