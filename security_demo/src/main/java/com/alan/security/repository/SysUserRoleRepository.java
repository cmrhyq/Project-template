package com.alan.security.repository;

import com.alan.security.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alan Huang
 * @version v1
 * @Title SysUserRole
 * @date 2021/6/5-20:03
 * @Email cmrhyq@163.com
 */
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Integer> {
    /**
     * 通过id查询数据
     *
     * @param userId
     * @return
     */
    List<SysUserRole> findByUserId(int userId);
}
