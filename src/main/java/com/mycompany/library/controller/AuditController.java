package com.mycompany.library.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.library.model.Audit;
import com.mycompany.library.service.AuditService;

@RestController(value = "/audit")
public class AuditController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuditController.class);

	@Autowired
	private AuditService auditService;
	
	@GetMapping(value = "/reports")
	public ResponseEntity<List<Audit>> getAllReports(){
		
		LOGGER.info("Getting all reports info-->");
		List<Audit> audits = auditService.getReports();
		if(audits.size() == 0)
			LOGGER.info("No records found");
		else
			LOGGER.info("Successfully retrieved all users info");
		return new ResponseEntity<>(audits, HttpStatus.OK);
	}
	
	@GetMapping(value = "/reportsForTimeline")
	public ResponseEntity<List<Audit>> getAllReportsForTimeline(LocalDateTime startDate, LocalDateTime endDate){
		
		LOGGER.info("Getting all reports info for timeline-->");
		List<Audit> audits = auditService.getReportsForTimeline(startDate, endDate);
		if(audits.size() == 0)
			LOGGER.info("No records found");
		else
			LOGGER.info("Successfully retrieved all users info");
		return new ResponseEntity<>(audits, HttpStatus.OK);
	}
}
