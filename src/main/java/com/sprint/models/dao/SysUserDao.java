package com.sprint.models.dao;

import com.sprint.models.domain.SysUser;
public interface SysUserDao {
	SysUser findByUsername(String username);
}
