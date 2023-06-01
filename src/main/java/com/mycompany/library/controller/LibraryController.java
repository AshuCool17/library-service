/**
 * 
 */
package com.mycompany.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.library.model.Book;
import com.mycompany.library.service.LibraryService;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;

	@PostMapping(value = "/addBook")
	public ResponseEntity<Book> addBooksToLibrary(Book book) {
		
		libraryService.addBookToLibrary(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBookByName")
	public ResponseEntity<Book> getBookByName(String name){
		
		Book book = libraryService.getBookByName(name);
		if(null != book)
			return new ResponseEntity<>(book, HttpStatus.OK);
		else
			return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
	}

}
