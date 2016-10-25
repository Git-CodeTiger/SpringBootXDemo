package com.sprint.services;

import com.sprint.models.domain.SysRole;
import com.sprint.models.dao.SysRoleDao;
import com.sprint.models.dao.SysUserDao;
import com.sprint.models.domain.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Service
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	private SysUserDao sysUserDao;	
	
	@Autowired
	private SysRoleDao sysRoleDao;

	@Override
	public UserDetails loadUserByUsername(String username) {
		SysUser user = sysUserDao.findByUsername(username);
		SysRole role = sysRoleDao.findBySysUserId(user.getId());
		user.setRole(role.getName());	
		if (user == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}
}
