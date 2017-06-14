package com.prayaas.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activityregistration database table.
 * 
 */
@Entity
@NamedQuery(name="Activityregistration.findAll", query="SELECT a FROM Activityregistration a")
public class Activityregistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTIVITYREGISTRATION_ACTIVITY_REGID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ACTIVITYREGISTRATION_ACTIVITY_REGID_GENERATOR")
	private int activity_Regid;

	//bi-directional many-to-one association to Activitytable
	@ManyToOne
	@JoinColumn(name="Activity_Id")
	private Activitytable activitytable;

	//bi-directional many-to-one association to Usertable
	@ManyToOne
	@JoinColumn(name="User_Id")
	private Usertable usertable;

	public Activityregistration() {
	}

	public int getActivity_Regid() {
		return this.activity_Regid;
	}

	public void setActivity_Regid(int activity_Regid) {
		this.activity_Regid = activity_Regid;
	}

	public Activitytable getActivitytable() {
		return this.activitytable;
	}

	public void setActivitytable(Activitytable activitytable) {
		this.activitytable = activitytable;
	}

	public Usertable getUsertable() {
		return this.usertable;
	}

	public void setUsertable(Usertable usertable) {
		this.usertable = usertable;
	}

}