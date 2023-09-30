package com.mycompany.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mycompany.library.controller.LibraryController;
import com.mycompany.library.dao.LibraryDao;
import com.mycompany.library.dao.UserDao;
import com.mycompany.library.exception.LibraryException;
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
	public Book addBookToLibrary(Book book) throws LibraryException{
		return libraryDao.save(book);
	}

	@Override
	public Optional<Book> findBookById(Long id) throws LibraryException{
		return libraryDao.findById(id);
	}

	@Override
	public List<Book> getAllBooks(String name) {
		return libraryDao.findAll();
	}

	@Override
	public void deleteBookById(Long id) throws LibraryException{
		libraryDao.deleteById(id);
	}

	@Override
	public Double calculateFine(long userId) throws LibraryException{
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

	@Override
	public Long getCountOfAllBooks() throws LibraryException;{
		return libraryDao.count(); //
	}

	@Override
	public String issueBook(String name) {
		Long countOfBooks = getCountOfAllBooks();
		String msg = null;
		LOGGER.info("Total books -->" + countOfBooks);
		if(countOfBooks > 0) {
			List<Book> bookList = getAllBooks(name);
			if(bookList.size() > 0) {
				if(bookList.get(0).getBookName().equalsIgnoreCase(name))
					libraryDao.issueBook(name);
			}else {
				LOGGER.info("Currently, the book with the name " + name + "is unavailable in library");
				msg = "Currently, the book with the name " + name + "is unavailable in library";
			}
			
		}else {
			LOGGER.info("No books in library");
			msg = "No books in library";
		}
		return msg;
		
	}
	
}
