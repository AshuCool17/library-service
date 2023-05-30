/**
 * 
 */
package com.mycompany.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.library.model.Book;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/library")
public class LibraryController {

	@PostMapping(value = "/addBooks")
	public ResponseEntity<Book> addBooksToLibrary(Book book) {
		
		//libraryService.addBook(book);
		return (ResponseEntity<Book>) new ResponseEntity<>(HttpStatus.OK).getBody();
	}

}
