package com.mycompany.library.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.library.dao.LibraryDao;
import com.mycompany.library.model.Audit;
import com.mycompany.library.service.AuditService;

public class AuditServiceImpl implements AuditService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceImpl.class);

	private AuditDao auditDao;
	
	@Override
	public List<Audit> getReports() {
		return null;
	}

}
