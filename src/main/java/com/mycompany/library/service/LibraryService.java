/**
 * 
 */
package com.mycompany.library.service;

import java.util.List;
import java.util.Optional;

import com.mycompany.library.model.Book;

/**
 * @author Ashutosh
 *
 */
public interface LibraryService {

	Book addBookToLibrary(Book book);//add new book into library

	Optional<Book> findBookById(Long id);//retrieve book by book id

	List<Book> getAllBooks(String name);//retrieve book by book name

	void deleteBookById(Long id);//delete book by book id

	Double calculateFine(long userId);

}
