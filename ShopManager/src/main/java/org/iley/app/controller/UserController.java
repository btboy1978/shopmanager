package org.iley.app.controller;

import java.util.List;

import org.iley.app.model.SysUser;
import org.iley.app.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@RestController
public class UserController {

	@Autowired
	private SysUserServiceImpl sysUserServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<SysUser> list() {
		return sysUserServiceImpl.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public SysUser detail(@PathVariable Integer id) {
		return sysUserServiceImpl.findByid(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public SysUser create(SysUser sysUser) {
		return sysUserServiceImpl.save(sysUser);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public SysUser update(SysUser sysUser) {
		
		return null;
	}

}