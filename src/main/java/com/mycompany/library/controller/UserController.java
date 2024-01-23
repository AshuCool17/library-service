/**
 * 
 */
package com.mycompany.library.controller;

import java.util.ArrayList;
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

import com.mycompany.library.exception.LibraryException;
import com.mycompany.library.exception.UserException;
import com.mycompany.library.exception.UserNotFoundException;
import com.mycompany.library.model.Librarian;
import com.mycompany.library.model.User;
import com.mycompany.library.service.LibraryService;
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
	
	@Autowired
	private LibraryService libraryService;

	@PostMapping(value = "/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){

		LOGGER.info("Adding user-->");
		try {
			User userObj = userService.addUser(user);
			LOGGER.info("User with user id - {}, added succesfully", user.getId());
			return new ResponseEntity<>(userObj, HttpStatus.OK);
		}catch(UserException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/addLibrarian")
	public ResponseEntity<Librarian> addLibrarian(@RequestBody Librarian librarian){

		LOGGER.info("Adding Librarian-->");
		try {
			Librarian librarianObj = userService.addLibrarian(librarian);
			LOGGER.info("Librarian with id - {}, added succesfully", librarian.getId());
			return new ResponseEntity<>(librarianObj, HttpStatus.OK);
		}catch(UserException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam long id){

		LOGGER.info("Deleting user-->");
		try {
			Optional<User> userObj = userService.getUserById(id);
			if(userObj.isPresent()) {
				userService.deleteUser(id);
				LOGGER.info("User with user id - {}, deleted successfully", id);
				return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
			}else {
				LOGGER.info("Unable to find user record with id: {}", id);
				return new ResponseEntity<>("Unable to find user record with id: " + id, HttpStatus.NOT_FOUND);
			}
		}catch(UserNotFoundException | UserException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user){

		LOGGER.info("Updating user-->");
		try{
			Optional<User> userObj = userService.getUserById(user.getId());
			if(userObj.isPresent()) {
				User updatedUser = userService.updateUser(user);
				LOGGER.info("User with user id - {}, updated uccessfully", updatedUser.getId());
				return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
			}else {
				LOGGER.info("Unable to find user record with id: {}" + user.getId());
				return new ResponseEntity<>("Unable to find user record with id:" + user.getId(), HttpStatus.NOT_FOUND);
			}
		}catch(UserNotFoundException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getUserById")
	public ResponseEntity<Optional<User>> getUserById(@RequestParam long id){

		LOGGER.info("Getting user info-->");
		try{
			Optional<User> userObj = userService.getUserById(id);
			if(userObj.isPresent()) {
				LOGGER.info("User details with user id - {}, {}", id, userObj.toString());
				return new ResponseEntity<>(userObj, HttpStatus.OK);
			} else {
				LOGGER.info("Unable to find user record with id: {}", id);
				return new ResponseEntity<>(userObj, HttpStatus.NOT_FOUND);
			}
		}catch(UserNotFoundException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){

		LOGGER.info("Getting all users info-->");
		try {
			List<User> users = userService.getAllUsers();
			if(users.size() == 0)
				LOGGER.info("No records found");
			else
				LOGGER.info("Successfully retrieved all users info");
			return new ResponseEntity<>(users, HttpStatus.OK);
		}catch(UserNotFoundException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/getNotificationsForNewArrivals")
	public ResponseEntity<List<String>> getNotificationsForNewArrivals(@RequestBody User user){
		List<String> books = new ArrayList<>();
		if(user.isHasSubscription()) {
			try {
				books = libraryService.upcomingBooks();
				return new ResponseEntity<>(books, HttpStatus.OK);
			} catch (LibraryException e) {
				LOGGER.error("Exception - " + e.getMessage());
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/getUserForBookIssued")
	public ResponseEntity<User> getUserForBookIssued(@RequestBody String bookName){
		User user = userService.getUserForBookIssued(bookName);
		if(null != user) {
			String userCountry = user.getCountry();
			LOGGER.info("user country " + userCountry);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			LOGGER.info("user not found " + user.getName());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value = "/deleteLibrarian")
	public ResponseEntity<String> deleteLibrarian(@RequestParam long id){

		LOGGER.info("Deleting Librarian-->");
		try {
			Optional<Librarian> librarianObj = userService.getLibrarianById(id);
			if(librarianObj != null) {
				userService.deleteLibrarian(id);
				LOGGER.info("Librarian with id - {}, deleted successfully", id);
				return new ResponseEntity<>("Librarian deleted successfully", HttpStatus.OK);
			}else {
				LOGGER.info("Unable to find Librarian record with id: {}", id);
				return new ResponseEntity<>("Unable to find Librarian record with id: " + id, HttpStatus.NOT_FOUND);
			}
		}catch(UserNotFoundException | UserException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateLibrarian")
	public ResponseEntity<String> updateLibrarian(@RequestBody Librarian librarian){

		LOGGER.info("Updating librarian Object-->");
		try{
			Optional<Librarian> librarianObj = userService.getLibrarianById(librarian.getId());
			if(librarianObj != null) {
				Librarian librarianUser;
				try {
					librarianUser = userService.updateLibrarian(librarian);
					LOGGER.info("Librarian with id - {}, updated successfully", librarianUser.getId());
					return new ResponseEntity<>("Librarian record updated successfully", HttpStatus.OK);
				} catch (UserException e) {
					LOGGER.error("Exception - " + e.getMessage());
				}
			}else {
				LOGGER.info("Unable to find Librarian record with id: {}" + librarian.getId());
				return new ResponseEntity<>("Unable to find user record with id:" + librarian.getId(), HttpStatus.NOT_FOUND);
			}
		}catch(UserNotFoundException e) {
			LOGGER.error("Exception - " + e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<String> login(String userName, String encryptedPwd){
		LOGGER.info("Login");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
