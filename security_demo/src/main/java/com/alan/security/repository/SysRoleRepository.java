package com.alan.security.repository;

import com.alan.security.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alan Huang
 * @version v1
 * @Title SysRoleRepository
 * @date 2021/6/5-19:51
 * @Email cmrhyq@163.com
 */
public interface SysRoleRepository extends JpaRepository<SysRole,Long> {
}
