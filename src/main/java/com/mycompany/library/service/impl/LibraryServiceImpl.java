package com.mycompany.library.service.impl;

import org.springframework.stereotype.Service;

import com.mycompany.library.model.Book;
import com.mycompany.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	/**
	 * add new book into library
	 */
	@Override
	public Book addBookToLibrary(Book book) {
		return null;
	}

	@Override
	public Book getBookByName(String name) {
		return null;
	}

}
