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

	Librarian addLibrarian(Librarian librarian) throws UserException;//add new librarian

	Optional<Librarian> getLibrarianById(long id) throws UserNotFoundException;//retrieve Librarian details based upon id

	void deleteLibrarian(long id) throws UserException;//delete librarian

	Librarian updateLibrarian(Librarian librarian) throws UserException;

	void login(String userName, String password);

	Optional<User> getUserByName(String name);//retrieve user for the book issued

	Optional<User> getUserByBookName(String bookName);
	
}
