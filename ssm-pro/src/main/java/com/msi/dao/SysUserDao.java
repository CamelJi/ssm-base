package com.msi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msi.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserDao extends BaseMapper<SysUser> {

    SysUser getUserByUsername(String username);

    void saveSysUser(SysUser sysUser);

    List<SysUser> getUserAll();

    SysUser getUserByUsernameAndPassword(Map<String, Object> map);
}
