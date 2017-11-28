package org.iley.app.controller;


import org.iley.app.model.SysUser;
import org.iley.app.security.UrlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	UrlUserService userService;

	@RequestMapping(value = "/login")
	public String login(@AuthenticationPrincipal SysUser loginedUser,
			@RequestParam(name = "logout", required = false) String logout) {
		if (logout != null) {
			return null;
		}
		if (loginedUser != null) {
			return "index";
		}
		return "login";
	}
}
