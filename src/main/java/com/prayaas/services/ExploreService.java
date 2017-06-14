package com.prayaas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prayaas.daos.ExploreDao;
import com.prayaas.pojos.Usertable;
import com.prayaas.pojos.Activitytable;

@Service
@Transactional
public class ExploreService {

	@Autowired
	ExploreDao dao;
	
	public Usertable validate(Usertable user) {
		Usertable userLogin = dao.find(user.getUser_Email());
		if(userLogin != null && userLogin.getUser_Password().equals(user.getUser_Password()))
			return userLogin;
		return null;
	}
	
	public Integer registerUser(Usertable user){
		return dao.registerUser(user);
	}
	
	public List<Activitytable> getActivityDetails(String user_City) {
		
		return dao.findActivity(user_City);
	}

	public Activitytable getActivityInfo(int activity_Id) {
		return dao.getActivityDetails(activity_Id);
	}

	public Integer registerForAct(Usertable user, Activitytable activity) {
		// TODO Auto-generated method stub
		return dao.registerForAct(user, activity);
	}
}
