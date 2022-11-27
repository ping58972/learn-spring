package com.infy.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.model.Error;
import com.infy.model.User;


@CrossOrigin
@RestController
@RequestMapping("userAPI")
public class UserAPI {
	static Logger logger = LogManager.getLogger(BooksAPI.class);
	@Autowired
	Environment environment;

	@RequestMapping(value="login",method=RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user)throws Exception {
		
		try {
			if(user != null && user.getUserName().equals("andy") && user.getPass().equals("andy123")){
				user.setMessage(environment.getProperty("API.USER_LOGIN_SUCCESS")+" "+user.getUserName());
				return new ResponseEntity<>(user,HttpStatus.OK);
			} else {
				Error error = new Error();
				error.setMessage(environment.getProperty("API.USER_LOGIN_FAILURE"));
				user.setError(error);
				return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,	e.getMessage(), e);
		}
	}
}
