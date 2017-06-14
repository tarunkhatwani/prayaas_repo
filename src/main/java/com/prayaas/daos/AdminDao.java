package com.prayaas.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prayaas.pojos.Activitytable;

@Repository
public class AdminDao {
	
	@Autowired
	private SessionFactory factory;
	
	public Integer uploadActivity(Activitytable activity){
		return (Integer) factory.getCurrentSession().save(activity);
	}
}
