/**
 * 
 */
package com.mycompany.library.controller;

import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	private LibraryService libraryService;

	@PostMapping(value = "/addBook")
	public ResponseEntity<Book> addBooksToLibrary(@RequestBody Book book) {
		
		libraryService.addBookToLibrary(book);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findBookByName")
	public ResponseEntity<Optional<Book>> findBookByName(@RequestParam(name = "id")Long id){
		
		Optional<Book> book = libraryService.findBookById(id);
		if(null != book)
			return new ResponseEntity<>(book, HttpStatus.OK);
		else
			return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(name = "name")String name){
		
		List<Book> booksList = libraryService.getAllBooks(name);
		if(!booksList.isEmpty())
			return new ResponseEntity<>(booksList, HttpStatus.OK);
		else
			return new ResponseEntity<>(booksList, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/deleteBookByName")
	public ResponseEntity<Optional<Book>> deleteBookByName(@RequestParam(name = "id")Long id){
		
		Optional<Book> book = libraryService.findBookById(id);
		if(null != book) {
			libraryService.deleteBookById(id);
			return new ResponseEntity<>(book, HttpStatus.OK);
		}else
			return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value = "/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		
		Optional<Book> bookObj = libraryService.findBookById(book.getBookId());
		if(null != bookObj) {
			libraryService.addBookToLibrary(book);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}else
			return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
	}

}
