package org.iley.app.security;

import org.iley.app.model.SysUser;
import org.iley.app.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UrlUserService implements UserDetailsService {
	@Autowired
	SysUserServiceImpl sysUserService;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		// 重写loadUserByUsername // 方法获得// userdetails // 类型用户
		SysUser user = sysUserService.findByUsername(userName);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
		}
	}
}