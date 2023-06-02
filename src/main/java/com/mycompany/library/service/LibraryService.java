/**
 * 
 */
package com.mycompany.library.service;

import java.util.List;

import com.mycompany.library.model.Book;

/**
 * @author Ashutosh
 *
 */
public interface LibraryService {

	Book addBookToLibrary(Book book);//add new book into library

	Book getBookByName(String name);//retrieve book by book name

	List<Book> getAllBooks(String name);//retrieve book by book name

}
