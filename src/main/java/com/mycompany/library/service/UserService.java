/**
 * 
 */
package com.mycompany.library.service;

import java.util.List;
import java.util.Optional;

import com.mycompany.library.model.User;

/**
 * @author Ashutosh
 *
 */
public interface UserService {

	User addUser(User user);//add new user

	void deleteUser(long id);//delete user

	User updateUser(User user);//update user

	Optional<User> getUserById(long id);//retrieve user details based upon id

	List<User> getAllUsers();//retrieve all users
	
}
