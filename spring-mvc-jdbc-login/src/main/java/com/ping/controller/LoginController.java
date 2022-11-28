package com.ping.controller;

import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ping.dto.UserDto;
import com.ping.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login.html")
	public String goToLoginPage() {
		System.out.println("jhasd");
		return "login.jsp";
	}
	
	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String validateUser(@RequestParam("username") String username, @RequestParam("password") String password) {
		UserDto userDto = loginService.getUserByUsernameAndPassword(username, password);
		if(userDto == null) {
			System.out.println("skdfjj");
			return "login.jsp";
		}
		else {
			System.out.println("Success!");
			return "dashboard.jsp";
		}
	}
}
