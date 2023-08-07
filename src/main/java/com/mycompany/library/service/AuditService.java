/**
 * 
 */
package com.mycompany.library.service;

import java.util.Date;
import java.util.List;

import com.mycompany.library.model.Audit;

/**
 * @author Ashutosh
 *
 */
public interface AuditService {

	List<Audit> getReports();

	List<Audit> getReportsForTimeline(Date startDate, Date endDate);

	
}
