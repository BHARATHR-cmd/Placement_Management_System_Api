package net.Placement_Manage_System.springboot.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="placements")
public class Placement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "year")
	private String year;

	@Override
	public String toString() {
		return "Placement [id=" + id + ", name=" + name + ", college=" + college + ", date=" + date
				+ ", qualification=" + qualification + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(college, date, name, id, qualification, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Placement other = (Placement) obj;
		return Objects.equals(college, other.college) && Objects.equals(date, other.date)
				&& Objects.equals(name, other.name) && id == other.id
				&& Objects.equals(qualification, other.qualification) && Objects.equals(year, other.year);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	
	
	
	
	
	}
