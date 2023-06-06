/**
 * 
 */
package com.mycompany.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		User userObj = userService.addUser(user);
		return new ResponseEntity<>(userObj, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Optional> deleteUser(@RequestParam long id){
		
		userService.deleteUser(id);
		return new ResponseEntity<Optional>(HttpStatus.OK);
	}
	
}
