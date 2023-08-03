package com.mycompany.library.service.impl;

import java.util.List;

import com.mycompany.library.dao.AuditDao;
import com.mycompany.library.model.Audit;
import com.mycompany.library.service.AuditService;

public class AuditServiceImpl implements AuditService {

	private AuditDao auditDao;
	
	@Override
	public List<Audit> getReports() {
		return auditDao.findAll();
	}

}
