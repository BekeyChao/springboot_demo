package com.bekey.service;

import com.bekey.domain.SysUser;
import com.bekey.repository.SysUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * transactional 开启事务
 * Created by bekey on 2017/12/9.
 */
@Service("SysUserService")
@Transactional
public class SysUserServiceImpl implements SysUserService{
    private static Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public boolean nameExists(String name) {
        return userRepository.findFirstByName(name) != null;
    }

    @Override
    public SysUser save(SysUser user) {
        SysUser sysUser = userRepository.save(user);
        log.info("register:" + sysUser.getId());
        return sysUser;
    }

    @Override
    public SysUser checkLogin(String name, String password) {
        return userRepository.findFirstByNameAndPassword(name, password);
    }
}
