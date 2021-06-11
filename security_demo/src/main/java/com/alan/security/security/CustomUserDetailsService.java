package com.alan.security.security;

import com.alan.security.entity.SysRole;
import com.alan.security.entity.SysUser;
import com.alan.security.entity.SysUserRole;
import com.alan.security.repository.SysRoleRepository;
import com.alan.security.repository.SysUserRepository;
import com.alan.security.repository.SysUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Alan Huang
 * @version v1
 * @Title UserDetailsService
 * @date 2021/6/6-10:48
 * @Email cmrhyq@163.com
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private SysRoleRepository sysRoleRepository;
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    /**
     * 重写UserDetailsService的loadUserByUsername方法
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser user = sysUserRepository.findByName(username);
//        判断用户是否存在
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        List<SysUserRole> userRoles = sysUserRoleRepository.findByUserId(user.getId());
        for (SysUserRole userRole:
             userRoles) {
            SysRole role = sysRoleRepository.findById(userRole.getUserId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(user.getName(),user.getPassword(),authorities);
    }
}
