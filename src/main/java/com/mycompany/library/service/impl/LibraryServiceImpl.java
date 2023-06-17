package com.mycompany.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycompany.library.dao.LibraryDao;
import com.mycompany.library.model.Book;
import com.mycompany.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	private LibraryDao libraryDao;
	
	/**
	 * add new book into library
	 */
	@Override
	public Book addBookToLibrary(Book book) {
		return null;
	}

	@Override
	public Optional<Book> findBookById(Long id) {
		return libraryDao.findById(id);
	}

	@Override
	public List<Book> getAllBooks(String name) {
		return null;
	}

	@Override
	public void deleteBookById(Long id) {
		libraryDao.deleteById(id);
	}

}
