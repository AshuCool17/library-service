/**
 * 
 */
package com.mycompany.library.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.library.model.Audit;

/**
 * @author Ashutosh
 *
 */
@Repository
public interface AuditDao extends JpaRepository<Audit, Long> {

	@Query(value = "SELECT * FROM Audit WHERE LAST_UPDATED >= :startDate AND LAST_UPDATED <= :endDate", nativeQuery = true)
	List<Audit> getReportsForTimeline(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate) throws AuditNotFoundException;
}
