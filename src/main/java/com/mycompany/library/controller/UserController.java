/**
 * 
 */
package com.mycompany.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.library.model.User;
import com.mycompany.library.service.UserService;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		userService.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
