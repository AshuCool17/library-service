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

	User addUser(User user);

	void deleteUser(long id);

	User updateUser(User user);

	Optional<User> getUserById(long id);

	List<User> getAllUsers();
	
}
