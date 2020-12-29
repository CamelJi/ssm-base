package com.msi.service;

import com.msi.entity.SysUser;

import java.util.List;

public interface SysUserService {

    void saveSysUser(SysUser sysUser);

    List<SysUser> getUserAll();
}
