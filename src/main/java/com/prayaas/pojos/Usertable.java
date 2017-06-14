package com.prayaas.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usertable database table.
 * 
 */
@Entity
@NamedQuery(name="Usertable.findAll", query="SELECT u FROM Usertable u")
public class Usertable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERTABLE_USER_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="USERTABLE_USER_ID_GENERATOR")
	@Column(name="User_Id")
	private int user_Id;

	@Column(name="Gender")
	private String gender;

	@Column(name="Mobile_No")
	private String mobile_No;

	@Column(name="User_City")
	private String user_City;

	@Column(name="User_Email")
	private String user_Email;

	@Column(name="User_Name")
	private String user_Name;

	@Column(name="User_Password")
	private String user_Password;

	//bi-directional many-to-one association to Activityregistration
	@OneToMany(mappedBy="usertable")
	private List<Activityregistration> activityregistrations;

	public Usertable() {
	}

	public int getUser_Id() {
		return this.user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile_No() {
		return this.mobile_No;
	}

	public void setMobile_No(String mobile_No) {
		this.mobile_No = mobile_No;
	}

	public String getUser_City() {
		return this.user_City;
	}

	public void setUser_City(String user_City) {
		this.user_City = user_City;
	}

	public String getUser_Email() {
		return this.user_Email;
	}

	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}

	public String getUser_Name() {
		return this.user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getUser_Password() {
		return this.user_Password;
	}

	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}

	public List<Activityregistration> getActivityregistrations() {
		return this.activityregistrations;
	}

	public void setActivityregistrations(List<Activityregistration> activityregistrations) {
		this.activityregistrations = activityregistrations;
	}

	public Activityregistration addActivityregistration(Activityregistration activityregistration) {
		getActivityregistrations().add(activityregistration);
		activityregistration.setUsertable(this);

		return activityregistration;
	}

	public Activityregistration removeActivityregistration(Activityregistration activityregistration) {
		getActivityregistrations().remove(activityregistration);
		activityregistration.setUsertable(null);

		return activityregistration;
	}

	@Override
	public String toString() {
		return "Usertable [user_Id=" + user_Id + ", gender=" + gender + ", mobile_No=" + mobile_No + ", user_City="
				+ user_City + ", user_Email=" + user_Email + ", user_Name=" + user_Name + ", user_Password="
				+ user_Password + ", activityregistrations=" + activityregistrations + "]";
	}
	
	

}