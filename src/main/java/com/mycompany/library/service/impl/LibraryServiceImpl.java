package com.mycompany.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.library.controller.LibraryController;
import com.mycompany.library.dao.LibraryDao;
import com.mycompany.library.dao.UserDao;
import com.mycompany.library.model.Book;
import com.mycompany.library.model.User;
import com.mycompany.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryServiceImpl.class);

	private LibraryDao libraryDao;
	
	private UserDao userDao;
	
	/**
	 * add new book into library
	 */
	@Override
	public Book addBookToLibrary(Book book) {
		return libraryDao.save(book);
	}

	@Override
	public Optional<Book> findBookById(Long id) {
		return libraryDao.findById(id);
	}

	@Override
	public List<Book> getAllBooks(String name) {
		return libraryDao.findAll();
	}

	@Override
	public void deleteBookById(Long id) {
		libraryDao.deleteById(id);
	}

	@Override
	public Double calculateFine(long userId) {
		LOGGER.info("Calculating fine-->");
		User user = userDao.getById(userId);//find the user by id
		if(user.getReturnDate().compareTo(user.getIssueDate()) == 0){
			user.setPenalty(0.0d);
		}else if(user.getReturnDate().compareTo(user.getIssueDate()) > 0){
			user.setPenalty(10.0d);
		}else if(user.getReturnDate().compareTo(user.getIssueDate()) < 0){
			user.setPenalty(0.0d);
		}
		return user.getPenalty();//calculate penalty for the user
	}
	
}
