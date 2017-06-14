package com.prayaas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prayaas.daos.AdminDao;
import com.prayaas.pojos.Activitytable;

@Service
@Transactional
public class AdminService {
	
	@Autowired
	private AdminDao dao;
	
	public Integer uploadActivity(Activitytable activity){
		return dao.uploadActivity(activity);
	}
}
