package com.msi.dao;

import com.msi.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> findUserList(User user);
}
