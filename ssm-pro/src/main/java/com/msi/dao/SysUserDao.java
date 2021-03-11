package com.msi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msi.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserDao extends BaseMapper<SysUser> {

    SysUser getUserByUsername(String username);

    void saveSysUser(SysUser sysUser);

    List<SysUser> getUserAll();

    SysUser getUserByUsernameAndPassword(Map<String, Object> map);

    IPage<SysUser> selectPageVo(@Param("userName") String userName, Page<SysUser> page);
}
