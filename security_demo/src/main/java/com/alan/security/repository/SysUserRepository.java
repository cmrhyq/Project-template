package com.alan.security.repository;

import com.alan.security.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Alan Huang
 * @version v1
 * @Title SysUserRepository
 * @date 2021/6/5-20:00
 * @Email cmrhyq@163.com
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    /**
     * 通过用户名查询信息
     *
     * @param userName
     * @return
     */
    SysUser findByName(String userName);
}
