package com.mycompany.library.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.library.dao.AuditDao;
import com.mycompany.library.model.Audit;
import com.mycompany.library.service.AuditService;

@Service
public class AuditServiceImpl implements AuditService {

	private AuditDao auditDao;
	
	@Override
	public List<Audit> getReports() {
		return auditDao.findAll();
	}

	@Override
	public List<Audit> getReportsForTimeline(Date startDate, Date endDate) {
		auditDao.find
		return null;
	}

}
