package net.Placement_Manage_System.springboot.service;

import java.util.List;

import net.Placement_Manage_System.springboot.model.Student;

public interface StudentService {
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(long id);
	Student updateStudent(Student student, long id);
	void deleteStudent(long id);
}
