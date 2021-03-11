package com.msi.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msi.core.ResponseResult;
import com.msi.core.bean.ResultBean;
import com.msi.entity.User;
import com.msi.service.UserService;
import com.msi.vo.UserVO;
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
    private ResponseResult responseResult;

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

        List<User> userList = null;// userService.findUserList(user);
        result.put("data", userList);

        return result;
    }


    @RequestMapping("/getDemo")
    public ResultBean getDemo(UserVO userVO) {
        Page<UserVO> page = new Page<>(userVO.getCurrent(),userVO.getSize());
        return responseResult.result(page, () -> userService.findUserList(userVO));
    }
}

