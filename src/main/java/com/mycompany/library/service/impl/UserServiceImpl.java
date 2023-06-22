/**
 * 
 */
package com.mycompany.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycompany.library.dao.UserDao;
import com.mycompany.library.model.User;
import com.mycompany.library.service.UserService;

/**
 * @author Ashutosh
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Override
	public User addUser(User user) {
		
		return userDao.save(user);
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	public Optional<User> getUserById(long id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

}
