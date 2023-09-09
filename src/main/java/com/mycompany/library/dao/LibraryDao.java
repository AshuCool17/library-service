/**
 * 
 */
package com.mycompany.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.library.model.Book;

/**
 * @author Ashutosh
 *
 */
@Repository
public interface LibraryDao extends JpaRepository<Book, Long> {

	@Query(value = "SELECT * FROM Library WHERE name = :name", nativeQuery = true)
	void issueBook(@Param("name")String name);

}
