package net.Placement_Manage_System.springboot.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "collegeadmin", nullable = false)
	private String collegeadmin;
	
	@Column(name = "collegename")
	private String collegename;
	
	
	
	@Column(name = "location")
	private String location;



	@Override
	public String toString() {
		return "College [id=" + id + ", collegeadmin=" + collegeadmin + ", collegename=" + collegename + ", location="
				+ location + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(collegeadmin, collegename, id, location);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		College other = (College) obj;
		return Objects.equals(collegeadmin, other.collegeadmin) && Objects.equals(collegename, other.collegename)
				&& id == other.id && Objects.equals(location, other.location);
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCollegeadmin() {
		return collegeadmin;
	}



	public void setCollegeadmin(String collegeadmin) {
		this.collegeadmin = collegeadmin;
	}



	public String getCollegename() {
		return collegename;
	}



	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}

		}
