package net.Placement_Manage_System.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.Placement_Manage_System.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
