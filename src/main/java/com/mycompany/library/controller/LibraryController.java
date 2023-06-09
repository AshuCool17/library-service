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
		libraryService.addBookToLibrary(book);
		LOGGER.info("Book with book id - " +book.getBookId()+ ", added to library succesfully");
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findBookById")
	public ResponseEntity<Optional<Book>> findBookByName(@RequestParam(name = "id")Long id){
		
		LOGGER.info("Retrieving book by name-->");
		Optional<Book> book = libraryService.findBookById(id);
		if(null != book) {
			LOGGER.info("Book with id " + id + " retrieved successfully");
			return new ResponseEntity<>(book, HttpStatus.OK);
		}
		else {
			LOGGER.info("Unable to find book record with id: " + id);
			return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(name = "name")String name){
		
		LOGGER.info("Retrieving books-->");
		List<Book> booksList = libraryService.getAllBooks(name);
		if(!booksList.isEmpty()) {
			LOGGER.info("Books retrieved successfully");
			return new ResponseEntity<>(booksList, HttpStatus.OK);
		}
		else {
			LOGGER.info("Unable to find book records");
			return new ResponseEntity<>(booksList, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/deleteBookById")
	public ResponseEntity<Optional<Book>> deleteBookByName(@RequestParam(name = "id")Long id){
		
		LOGGER.info("Deleting book from library-->");
		Optional<Book> book = libraryService.findBookById(id);
		if(null != book) {
			libraryService.deleteBookById(id);
			LOGGER.info("Book with book id - "+id+", deleted successfully");
			return new ResponseEntity<>(book, HttpStatus.OK);
		}else {
			LOGGER.info("Unable to find book record with id:" + id);
			return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		
		LOGGER.info("Updating book-->");
		Optional<Book> bookObj = libraryService.findBookById(book.getBookId());
		if(null != bookObj) {
			libraryService.addBookToLibrary(book);
			LOGGER.info("Book with book id - "+book.getBookId()+", updated successfully");
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}else {
			LOGGER.info("Unable to find book record with id:" + book.getBookId());
			return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/calculateFine")
	public ResponseEntity<Double> calculateFine(@RequestParam long userId){
		
		Double fine = libraryService.calculateFine(userId);
		return new ResponseEntity<>(fine, HttpStatus.OK);
	}

}
