package com.bekey.repository;

import com.bekey.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户Dao层
 * Created by bekey on 2017/12/9.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long>{
    /**
     * 按照账户名查找
     */
    SysUser findFirstByName(String name);



}
