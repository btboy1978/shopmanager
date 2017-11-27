package org.iley.app.service;

import java.util.List;

import org.iley.app.model.SysUser;

public interface SysUserService {
	
	SysUser findByid(int id);

	SysUser save(SysUser sysUser);

	SysUser findByUsername(String username);

	List<SysUser> findAll();
}
