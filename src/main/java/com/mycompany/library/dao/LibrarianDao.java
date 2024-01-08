package com.mycompany.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.library.model.Librarian;

public interface LibrarianDao extends JpaRepository<Librarian, Long>{

}
