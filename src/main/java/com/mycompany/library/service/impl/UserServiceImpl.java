/**
 * 
 */
package com.mycompany.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycompany.library.dao.UserDao;
import com.mycompany.library.exception.UserException;
import com.mycompany.library.exception.UserNotFoundException;
import com.mycompany.library.model.Librarian;
import com.mycompany.library.model.User;
import com.mycompany.library.service.UserService;

/**
 * @author Ashutosh
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	private LibrarianDao librarianDao;
	
	@Override
	public User addUser(User user) throws UserException{
		return userDao.save(user);
	}

	@Override
	public void deleteUser(long id) throws UserException{
		userDao.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	public Optional<User> getUserById(long id) throws UserNotFoundException{
		return userDao.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserForBookIssued(String bookName) {
		return userDao.getUserForBookIssued(bookName);
	}

	@Override
	public Librarian addLibrarian(Librarian librarian) throws UserException {
		return librarianDao.save(librarian);
	}

}
