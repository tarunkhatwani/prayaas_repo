package com.prayaas.pojos;

import java.io.Serializable;
import javax.persistence.*;

//import org.springframework.format.annotation.DateTimeFormat;

//import java.sql.Time;
//import java.util.Date;
import java.util.List;


/**
 * The persistent class for the activitytable database table.
 * 
 */
@Entity
@NamedQuery(name="Activitytable.findAll", query="SELECT a FROM Activitytable a")
public class Activitytable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTIVITYTABLE_ACTIVITY_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ACTIVITYTABLE_ACTIVITY_ID_GENERATOR")
	private int activity_Id;

	@Column(name="Activity_Description")
	private String activity__Description;

	@Column(name="activity_Address")
	private String activity_Address;

	@Column(name="activity_City")
	private String activity_City;

//	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="activity_Enddate")
	private String activity_Enddate;

	@Column(name="activity_Name")
	private String activity_Name;

	//@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="activity_Startdate")
	private String activity_Startdate;

	@Column(name="activity_Time")
	private String activity_Time;
	
	@Column(name="Activity_Image", length=8000000)
	private String image;

	//bi-directional many-to-one association to Activityregistration
	@OneToMany(mappedBy="activitytable")
	private List<Activityregistration> activityregistrations;

	public Activitytable() {
	}

	public int getActivity_Id() {
		return this.activity_Id;
	}

	public void setActivity_Id(int activity_Id) {
		this.activity_Id = activity_Id;
	}

	public String getActivity__Description() {
		return this.activity__Description;
	}

	public void setActivity__Description(String activity__Description) {
		this.activity__Description = activity__Description;
	}

	public String getActivity_Address() {
		return this.activity_Address;
	}

	public void setActivity_Address(String activity_Address) {
		this.activity_Address = activity_Address;
	}

	public String getActivity_City() {
		return this.activity_City;
	}

	public void setActivity_City(String activity_City) {
		this.activity_City = activity_City;
	}

	public String getActivity_Enddate() {
		return this.activity_Enddate;
	}

	public void setActivity_Enddate(String activity_Enddate) {
		this.activity_Enddate = activity_Enddate;
	}

	public String getActivity_Name() {
		return this.activity_Name;
	}

	public void setActivity_Name(String activity_Name) {
		this.activity_Name = activity_Name;
	}

	public String getActivity_Startdate() {
		return this.activity_Startdate;
	}

	public void setActivity_Startdate(String activity_Startdate) {
		this.activity_Startdate = activity_Startdate;
	}

	public String getActivity_Time() {
		return this.activity_Time;
	}

	public void setActivity_Time(String activity_Time) {
		this.activity_Time = activity_Time;
	}

	public List<Activityregistration> getActivityregistrations() {
		return this.activityregistrations;
	}

	public void setActivityregistrations(List<Activityregistration> activityregistrations) {
		this.activityregistrations = activityregistrations;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Activityregistration addActivityregistration(Activityregistration activityregistration) {
		getActivityregistrations().add(activityregistration);
		activityregistration.setActivitytable(this);

		return activityregistration;
	}

	public Activityregistration removeActivityregistration(Activityregistration activityregistration) {
		getActivityregistrations().remove(activityregistration);
		activityregistration.setActivitytable(null);

		return activityregistration;
	}

	@Override
	public String toString() {
		return "Activitytable [activity_Id=" + activity_Id + ", activity__Description=" + activity__Description
				+ ", activity_Address=" + activity_Address + ", activity_City=" + activity_City + ", activity_Enddate="
				+ activity_Enddate + ", activity_Name=" + activity_Name + ", activity_Startdate=" + activity_Startdate
				+ ", activity_Time=" + activity_Time + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + activity_Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activitytable other = (Activitytable) obj;
		if (activity_Id != other.activity_Id)
			return false;
		return true;
	}
	
	

}