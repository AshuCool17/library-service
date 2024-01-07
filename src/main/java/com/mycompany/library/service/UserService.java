/**
 * 
 */
package com.mycompany.library.service;

import java.util.List;
import java.util.Optional;

import com.mycompany.library.exception.UserException;
import com.mycompany.library.exception.UserNotFoundException;
import com.mycompany.library.model.Librarian;
import com.mycompany.library.model.User;

/**
 * @author Ashutosh
 *
 */
public interface UserService {

	User addUser(User user) throws UserException;//add new user

	void deleteUser(long id) throws UserException;//delete user

	User updateUser(User user);//update user

	Optional<User> getUserById(long id) throws UserNotFoundException;//retrieve user details based upon id

	List<User> getAllUsers() throws UserNotFoundException;//retrieve all users

	User getUserForBookIssued(String bookName);//retrieve user for the book issued

	Librarian addLibrarian(Librarian librarian);//add new librarian
	
}
