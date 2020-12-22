package com.msi.service.impl;

import com.msi.dao.UserDao;
import com.msi.entity.User;
import com.msi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findUserList(User user) {
        return userDao.findUserList(user);
    }
}
