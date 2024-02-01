/**
 * 
 */
package com.mycompany.library.service.impl;

import java.util.Optional;

import com.mycompany.library.model.User;
import com.mycompany.library.service.LibrarianService;

/**
 * @author Ashutosh
 *
 */
public class LibrarianServiceImpl implements LibrarianService {

	@Override
	public Optional<User> getLibrarianByName(String name) {
		return Optional.empty();
	}

}
