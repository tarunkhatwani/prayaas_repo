package com.prayaas.daos;

import java.util.List;

//import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.prayaas.pojos.Activityregistration;
import com.prayaas.pojos.Activitytable;
import com.prayaas.pojos.Usertable;

@Repository
public class ExploreDao {

	@Autowired
	private SessionFactory factory;
	
	public Usertable find(String user_Email) {
		try {
			Session session = factory.getCurrentSession();
			System.out.println(user_Email);
			Criteria criteria = session.createCriteria(Usertable.class);
			criteria.add(Restrictions.eq("user_Email",user_Email));
			@SuppressWarnings("unchecked")
			List<Usertable> user = criteria.list();
			return user.get(0);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Error in dao find");
			return null;
		}

	}
	
	public Activitytable getActivityDetails(int activity_Id){
		try {
			/*String hql = "Select a from Activitytable a where a.activity_Id = :id";
			Activitytable activity = (Activitytable) factory.getCurrentSession().createQuery(hql).
					setParameter("id", activity_Id).uniqueResult();*/
			Activitytable activity=(Activitytable) factory.getCurrentSession().get(Activitytable.class, activity_Id);
			System.out.println(activity+"yyyyyyyyyyyyyyyyyy");
			return activity; 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in dao getActivitydetails");
			return null;
		}
	}
	
	public Integer registerUser(Usertable user){
		try {
			String hql = "Select u from Usertable u where u.user_Email = :ue";
			Usertable user1 = (Usertable) factory.getCurrentSession().createQuery(hql).setParameter("ue", 
					user.getUser_Email()).uniqueResult();
			if(user1 == null)
				return (Integer)factory.getCurrentSession().save(user);
			else
				return null;
		} catch (Exception e) {
			//System.out.println("Error in dao registerUser");
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Activitytable> findActivity(String user_City) {
		try {
			String hql = "Select a from Activitytable a"; /*where a.activity_City = :city*/
			List<Activitytable> activities = (List<Activitytable>) factory.getCurrentSession().createQuery(hql).list();
					/*setParameter("city", user_City)*/
			return activities;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in dao findActivity");
			return null;
		}
		//return null;
	}

	public Integer registerForAct(Usertable user, Activitytable activity/*, HttpSession hs*/) {
		// TODO Auto-generated method stub
		try {
			/*String hql = "Select a from Activitytable a where a.user_Id = :id";
			@SuppressWarnings("unchecked")
			List<Activitytable> activities = (List<Activitytable>) factory.getCurrentSession().createQuery(hql).
					setParameter("id", user.getUser_Id()).list();
			if(activities.contains(activity)){
				//hs.setAttribute("statusReg", "You are already registered");
				return null;
			}else{*/
				Activityregistration reg = new Activityregistration();
				reg.setUsertable(user);
				reg.setActivitytable(activity);
				Integer id = (Integer) factory.getCurrentSession().save(reg);
				return id;
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
