package com.mycompany.library.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.library.dao.AuditDao;
import com.mycompany.library.exception.AuditNotFoundException;
import com.mycompany.library.model.Audit;
import com.mycompany.library.service.AuditService;

@Service
public class AuditServiceImpl implements AuditService {

	private AuditDao auditDao;
	
	@Override
	public List<Audit> getReports() throws AuditNotFoundException {
		return auditDao.findAll();
	}

	@Override
	public List<Audit> getReportsForTimeline(LocalDateTime startDate, LocalDateTime endDate) throws AuditNotFoundException {
		return auditDao.getReportsForTimeline(startDate, endDate);
	}

}
