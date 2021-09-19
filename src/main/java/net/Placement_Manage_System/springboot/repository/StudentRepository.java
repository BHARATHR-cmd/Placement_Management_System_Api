package net.Placement_Manage_System.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.Placement_Manage_System.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
