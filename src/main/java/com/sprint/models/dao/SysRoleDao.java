package com.sprint.models.dao;

import com.sprint.models.domain.SysRole;
public interface SysRoleDao {
	SysRole findBySysUserId(Long id);
}
