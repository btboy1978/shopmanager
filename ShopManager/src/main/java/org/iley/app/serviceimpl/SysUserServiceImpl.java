package org.iley.app.serviceimpl;

import java.util.List;

import org.iley.app.model.SysUser;
import org.iley.app.repository.SysUserDao;
import org.iley.app.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public SysUser findByid(int id) {
		// TODO Auto-generated method stub
		return sysUserDao.findByid(id);
	}

	@Override
	public SysUser save(SysUser sysUser) {
		// TODO Auto-generated method stub
		return sysUserDao.save(sysUser);
	}

	@Override
	public SysUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return sysUserDao.findByUsername(username);
	}

	@Override
	public List<SysUser> findAll() {
		// TODO Auto-generated method stub
		return sysUserDao.findAll();
	}

}
