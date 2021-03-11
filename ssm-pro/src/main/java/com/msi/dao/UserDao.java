package com.msi.dao;

import com.msi.entity.User;
import com.msi.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<UserVO> findUserList(UserVO userVO);
}
