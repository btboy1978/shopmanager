package org.iley.app.repository;

import java.util.List;

import org.iley.app.model.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends BaseRepository<SysUser, Integer> {
	
	SysUser findByid(int id);

	SysUser save(SysUser sysUser);

	SysUser findByUsername(String username);

	List<SysUser> findAll();
}