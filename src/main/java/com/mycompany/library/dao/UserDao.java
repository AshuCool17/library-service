/**
 * 
 */
package com.mycompany.library.dao;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.library.model.User;

/**
 * @author Ashutosh
 *
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>{

	@NamedQuery(query = "select user.name from book")
	public String getUserForBookIssued(String bookName)
}
