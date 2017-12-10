package com.bekey.service;

import com.bekey.domain.SysUser;

/**
 * Created by bekey on 2017/12/9.
 */
public interface SysUserService {
    boolean nameExists(String name);

    SysUser save(SysUser user);
}
