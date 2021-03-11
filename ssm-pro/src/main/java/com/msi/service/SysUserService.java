package com.msi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.msi.entity.SysUser;

import java.util.List;

public interface SysUserService  {

    void saveSysUser(SysUser sysUser);

    List<SysUser> getUserAll();

    IPage<SysUser> selectPageVo(Page<SysUser> page, String userName);
}
