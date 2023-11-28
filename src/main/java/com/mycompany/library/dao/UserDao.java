/**
 * 
 */
package com.mycompany.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.library.model.User;

/**
 * @author Ashutosh
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>{

	@Query(value = "select user.name from book")
	public String getUserForBookIssued(String bookName);
}
