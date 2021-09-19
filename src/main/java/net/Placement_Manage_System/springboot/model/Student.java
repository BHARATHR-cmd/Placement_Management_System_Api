package net.Placement_Manage_System.springboot.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "roll")
	private String roll;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "certificate")
	private String certificate;
	
	@Column(name = "hallTicketNo")
	private String hallTicketNo;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", roll=" + roll + ", qualification="
				+ qualification + ", course=" + course + ", year=" + year + ", certificate=" + certificate
				+ ", hallTicketNo=" + hallTicketNo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificate, college, course, hallTicketNo, id, name, qualification, roll, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(certificate, other.certificate) && Objects.equals(college, other.college)
				&& Objects.equals(course, other.course) && Objects.equals(hallTicketNo, other.hallTicketNo)
				&& id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(qualification, other.qualification) && Objects.equals(roll, other.roll)
				&& Objects.equals(year, other.year);
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

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getHallTicketNo() {
		return hallTicketNo;
	}

	public void setHallTicketNo(String hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}

				}
