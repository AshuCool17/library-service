/**
 * 
 */
package com.mycompany.library.dao;

import java.util.Optional;

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

	@Query(value = "select user from book where bookname: bookname")
	public User getUserForBookIssued(String bookName);

	@Query(value = "select user from users where name: name")
	public Optional<User> getUserByName(String name);
}
