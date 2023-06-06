/**
 * 
 */
package com.mycompany.library.service;

import com.mycompany.library.model.User;

/**
 * @author Ashutosh
 *
 */
public interface UserService {

	User addUser(User user);

	void deleteUser(long id);

	
}
