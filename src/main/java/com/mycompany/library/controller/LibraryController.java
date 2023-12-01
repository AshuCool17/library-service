/**
 * 
 */
package com.mycompany.library.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.library.exception.BookNotFoundException;
import com.mycompany.library.exception.LibraryException;
import com.mycompany.library.model.Book;
import com.mycompany.library.service.LibraryService;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/library")
public class LibraryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryController.class);
	@Autowired
	private LibraryService libraryService;

	@PostMapping(value = "/addBook")
	public ResponseEntity<Book> addBooksToLibrary(@RequestBody Book book) {

		LOGGER.info("Adding book-->");
		try {
			libraryService.addBookToLibrary(book);
			LOGGER.info("Book with book id - " + book.getBookId() + ", added to library succesfully");
		}catch(LibraryException e) {
			LOGGER.error("exception -> "+e.getMessage());
			return new ResponseEntity<>(book, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@GetMapping(value = "/findBookById")
	public ResponseEntity<Optional<Book>> findBookById(@RequestParam(name = "id")Long id){

		LOGGER.info("Retrieving book by name-->");
		try{
			Optional<Book> book = libraryService.findBookById(id);
			if(null != book) {
				LOGGER.info("Book with id " + id + " retrieved successfully");
				return new ResponseEntity<>(book, HttpStatus.OK);
			}
			else {
				LOGGER.info("Unable to find book record with id: " + id);
				return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
			}
		}catch(BookNotFoundException e) {
			LOGGER.error("exception -> "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(name = "name")String name){

		LOGGER.info("Retrieving books-->");

		try{
			List<Book> booksList = libraryService.getAllBooks(name);
			if(!booksList.isEmpty()) {
				LOGGER.info("Books retrieved successfully");
				return new ResponseEntity<>(booksList, HttpStatus.OK);
			}
			else {
				LOGGER.info("Unable to find book records");
				return new ResponseEntity<>(booksList, HttpStatus.NOT_FOUND);
			}
		}catch(BookNotFoundException e) {
			LOGGER.error("exception -> "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteBookById")
	public ResponseEntity<Optional<Book>> deleteBookByName(@RequestParam(name = "id")Long id){

		LOGGER.info("Deleting book from library-->");
		try{
			Optional<Book> book = libraryService.findBookById(id);
			if(null != book) {
				libraryService.deleteBookById(id);
				LOGGER.info("Book with book id - " + id + ", deleted successfully");
				return new ResponseEntity<>(book, HttpStatus.OK);
			}else {
				LOGGER.info("Unable to find book record with id : " + id);
				return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
			}
		}catch(BookNotFoundException e) {
			LOGGER.error("exception -> "+e.getMessage());
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){

		LOGGER.info("Updating book-->");
		try{
			Optional<Book> bookObj = libraryService.findBookById(book.getBookId());
			if(null != bookObj) {
				libraryService.addBookToLibrary(book);
				LOGGER.info("Book with book id - " + book.getBookId() + ", updated successfully");
				return new ResponseEntity<Book>(book, HttpStatus.OK);
			}else {
				LOGGER.info("Unable to find book record with id : " + book.getBookId());
				return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
			}
		}catch(BookNotFoundException e) {
			LOGGER.error("exception -> "+e.getMessage());
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/calculateFine")
	public ResponseEntity<Double> calculateFine(@RequestParam long userId){

		LOGGER.info("Calculating fine-->");
		try{
			Double fine = libraryService.calculateFine(userId);
			if(fine == 0.0d) {
				LOGGER.info("No pending dues");
				return new ResponseEntity<>(fine, HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(fine, HttpStatus.OK);
		}catch(LibraryException e) {
			LOGGER.error("exception -> "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/getCountOfAllBooks")
	public ResponseEntity<Long> getCountOfAllBooks(){

		LOGGER.info("Retrieving books count-->");

		try{
			Long count = libraryService.getCountOfAllBooks();
			if(count != 0) {
				return new ResponseEntity<>(count, HttpStatus.OK);
			}
			else {
				LOGGER.info("No Books available");
				return new ResponseEntity<>(count, HttpStatus.NOT_FOUND);
			}
		}catch(LibraryException e) {
			LOGGER.error("exception -> "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/issueBook")
	public ResponseEntity<String> issueBook(String bookName){

		try{
			LOGGER.info("Issuing book API");
			List<Book> books = libraryService.getAllBooks(bookName);
			List<String> bookPublishedCountries = books.get(0).getCountry();
			LOGGER.info("book published countries -> " + bookPublishedCountries.toString());
			String msg = null;
			if(books.contains(bookPublishedCountries)) {
				msg = libraryService.issueBook(bookName);
				LOGGER.info("Issue Book response -> " + msg);
				return new ResponseEntity<>(msg, HttpStatus.OK);
			}
			LOGGER.info("Issue Book response. Not in the same country");
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(LibraryException e) {
			LOGGER.error("exception -> "+e.getMessage());
		} catch (BookNotFoundException e) {
			LOGGER.error("exception -> "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/upcomingBooks")
	public ResponseEntity<List<String>> upcomingBooks(){
		
		try {
			LOGGER.info("Upcoming books API");
			List<String> books = libraryService.upcomingBooks();
			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (LibraryException e) {
			LOGGER.error("exception -> "+e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
