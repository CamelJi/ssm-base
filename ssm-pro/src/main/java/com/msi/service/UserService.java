package com.msi.service;

import com.msi.vo.UserVO;

import java.util.List;

public interface UserService {

    List<UserVO> findUserList(UserVO userVO);
}
