package com.msi.service;

import com.msi.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUserList(User user);
}
