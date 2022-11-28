package com.ping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ping.dao.MenuDao;
import com.ping.dao.RoleDao;
import com.ping.dao.UserDao;
import com.ping.entity.Menu;
import com.ping.entity.RoleMenuMapping;
import com.ping.entity.User;
import com.ping.entity.UserRoleMapping;

@Service
public class LoginService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private MenuDao menuDao;

	public boolean isValidate(String username, String password) {
		User user = userDao.getUserByUsernameAndPassword(username, password);
		if (user == null) {
			return false;
		}
		return true;
	}

	public List<Menu> getMenuByUsername(String username) {
		User user = userDao.findUserByUsername(username);
		
		List<UserRoleMapping> roles = roleDao.findRoleIdsByUserId(user.getId());
		
		List<Menu> menus = new ArrayList<Menu>();
		
		for(UserRoleMapping userRoleMapping: roles) {
			List<RoleMenuMapping> roleMenuMappings = roleDao.findMenusByRoleId(userRoleMapping.getRole().getId());
			for(RoleMenuMapping roleMenuMapping: roleMenuMappings) {
				Menu menu = menuDao.findById(roleMenuMapping.getMenu().getId());
				menus.add(menu);
			}
		}
		return menus;
	}

}
