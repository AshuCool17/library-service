/**
 * 
 */
package com.mycompany.library.service;

import java.util.List;
import java.util.Optional;

import com.mycompany.library.exception.BookNotFoundException;
import com.mycompany.library.exception.LibraryException;
import com.mycompany.library.model.Book;

/**
 * @author Ashutosh
 *
 */
public interface LibraryService {

	Book addBookToLibrary(Book book) throws LibraryException;//add new book into library

	Optional<Book> findBookById(Long id) throws BookNotFoundException;//retrieve book by book id

	List<Book> getAllBooks(String name) throws BookNotFoundException;//retrieve book by book name

	void deleteBookById(Long id) throws LibraryException;//delete book by book id

	Double calculateFine(long userId) throws LibraryException;//calculating fine for a particular user

	Long getCountOfAllBooks() throws LibraryException;//get count of books in the library

	String issueBook(String name) throws BookNotFoundException, LibraryException;//issue book to the student

	List<String> upcomingBooks() throws LibraryException;//displays upcoming books

}
