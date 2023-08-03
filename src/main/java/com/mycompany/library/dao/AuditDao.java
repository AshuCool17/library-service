/**
 * 
 */
package com.mycompany.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.library.model.Audit;

/**
 * @author Ashutosh
 *
 */
@Repository
public interface AuditDao extends JpaRepository<Audit, Long> {

}
