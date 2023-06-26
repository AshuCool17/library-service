/**
 * 
 */
package com.mycompany.library.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		LOGGER.info("Adding user-->");
		User userObj = userService.addUser(user);
		LOGGER.info("User with user id -"+user.getId()+", added succesfully");
		return new ResponseEntity<>(userObj, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam long id){
		
		LOGGER.info("Deleting user-->");
		Optional<User> userObj = userService.getUserById(id);
		if(userObj.isPresent()) {
			userService.deleteUser(id);
			LOGGER.info("User with user id - "+id+", deleted uccessfully");
			return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
		}else {
			LOGGER.info("Unable to find user record with id:" + id);
			return new ResponseEntity<>("Unable to find user record with id:" + id, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		
		LOGGER.info("Updating user-->");
		Optional<User> userObj = userService.getUserById(user.getId());
		if(userObj.isPresent()) {
			User updatedUser = userService.updateUser(user);
			LOGGER.info("User with user id - "+user.getId()+", updated uccessfully");
			return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
		}else {
			LOGGER.info("Unable to find user record with id:" + user.getId());
			return new ResponseEntity<>("Unable to find user record with id:" + user.getId(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/getUserById")
	public ResponseEntity<Optional<User>> getUserById(@RequestParam long id){
		
		Optional<User> userObj = userService.getUserById(id);
		if(userObj.isPresent())
			return new ResponseEntity<>(userObj, HttpStatus.OK);
		else
			return new ResponseEntity<>(userObj, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
}
