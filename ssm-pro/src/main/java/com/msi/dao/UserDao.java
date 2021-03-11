package com.msi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msi.entity.User;
import com.msi.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao  extends BaseMapper<User> {

    List<UserVO> findUserList(UserVO userVO);
}
