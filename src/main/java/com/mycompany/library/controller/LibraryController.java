/**
 * 
 */
package com.mycompany.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/library")
public class LibraryController {

	@GetMapping(value = "/addBooksToLibrary")
	public ResponseEntity<String> addBooksToLibrary() {
		 return new ResponseEntity<>("Added Books", HttpStatus.OK);
	}

}
