/**
 * 
 */
package com.mycompany.library.service;

import java.time.LocalDateTime;
import java.util.List;

import com.mycompany.library.model.Audit;

/**
 * @author Ashutosh
 *
 */
public interface AuditService {

	List<Audit> getReports();

	List<Audit> getReportsForTimeline(LocalDateTime startDate, LocalDateTime endDate);

	
}
