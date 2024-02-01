package com.mycompany.library.service;

import java.util.Optional;

import com.mycompany.library.model.User;

public interface LibrarianService {

	Optional<User> getLibrarianByName(String name);

}
