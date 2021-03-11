package com.msi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msi.dao.SysUserDao;
import com.msi.entity.SysUser;
import com.msi.service.SysUserService;
import com.msi.shiro.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;


    public void saveSysUser(SysUser sysUser) {
        String password = sysUser.getPassword();
        String salt = UUID.randomUUID().toString().replace("-", "");
        sysUser.setSalt(salt);
        sysUser.setPassword(ShiroKit.md5(password,salt));
        sysUser.insert();
    }

    public List<SysUser> getUserAll() {
        SysUser sysUser = new SysUser();
        return sysUser.selectAll();
    }

    @Override
    public IPage<SysUser> selectPageVo(Page<SysUser> page, String userName) {
        return sysUserDao.selectPageVo(userName, page);
    }
}
