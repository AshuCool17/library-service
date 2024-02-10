package com.mycompany.library.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mycompany.library.model.Librarian;

public interface LibrarianDao extends JpaRepository<Librarian, Long>{

	@Query(value = "select * from librarian where name: name")
	public Optional<Librarian> getLibrarianByName(String name);
}
