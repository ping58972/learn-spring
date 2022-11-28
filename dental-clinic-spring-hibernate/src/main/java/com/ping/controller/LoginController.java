package com.ping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ping.entity.Menu;
import com.ping.entity.User;
import com.ping.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login.do")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping(value = "/dologin.do", method = RequestMethod.POST)
	public String validateUser(Model model, HttpSession Session, @RequestParam("username") String username, @RequestParam("password") String password ) {
		
		boolean status = loginService.isValidate(username, password);
		
		if(status) {
			//List<Menu> menuList = loginService.getMenuByUsername("username");
		//	model.addAttribute("menuList", menuList);
			return "dashboard.jsp";
		} else {
			return "login.jsp";
		}
	}
}
