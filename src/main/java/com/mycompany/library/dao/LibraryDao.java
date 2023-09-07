/**
 * 
 */
package com.mycompany.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.library.model.Book;

/**
 * @author Ashutosh
 *
 */
@Repository
public interface LibraryDao extends JpaRepository<Book, Long> {

	void issueBook(String name);

}
