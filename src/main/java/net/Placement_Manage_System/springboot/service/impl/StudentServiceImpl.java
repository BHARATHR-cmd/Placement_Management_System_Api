package net.Placement_Manage_System.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.Placement_Manage_System.springboot.exception.ResourceNotFoundException;
import net.Placement_Manage_System.springboot.model.Student;
import net.Placement_Manage_System.springboot.repository.StudentRepository;
import net.Placement_Manage_System.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository StudentRepository;
	
	public StudentServiceImpl(StudentRepository StudentRepository) {
		super();
		this.StudentRepository = StudentRepository;
	}

	@Override
	public Student saveStudent(Student Student) {
		return StudentRepository.save(Student);
	}

	@Override
	public List<Student> getAllStudents() {
		return StudentRepository.findAll();
	}

	@Override
	public Student getStudentById(long id) {
//		Optional<Student> Student = StudentRepository.findById(id);
//		if(Student.isPresent()) {
//			return Student.get();
//		}else {
//			throw new ResourceNotFoundException("Student", "Id", id);
//		}
		return StudentRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Student", "Id", id));
		
	}

	@Override
	public Student updateStudent(Student Student, long id) {
		
		// we need to check whether Student with given id is exist in DB or not
		Student existingStudent = StudentRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Student", "Id", id)); 
		
		existingStudent.setName(Student.getName());
		existingStudent.setCollege(Student.getCollege());
		existingStudent.setRoll(Student.getRoll());
		existingStudent.setQualification(Student.getQualification());
		existingStudent.setCourse(Student.getCourse());
		existingStudent.setYear(Student.getYear());
		existingStudent.setCertificate(Student.getCertificate());
		existingStudent.setHallTicketNo(Student.getHallTicketNo());
		
		
		
		// save existing Student to DB
		StudentRepository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(long id) {
		
		// check whether a Student exist in a DB or not
		StudentRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Student", "Id", id));
		StudentRepository.deleteById(id);
	}
	
}
