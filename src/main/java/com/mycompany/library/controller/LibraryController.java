/**
 * 
 */
package com.mycompany.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ashutosh
 *
 */
@RestController(value = "/library")
public class LibraryController {

	@GetMapping(value = "/addBooksToLibrary")
	public String addBooksToLibrary() {
		return "All Books";
	}

}
