package net.Placement_Manage_System.springboot.service;

import java.util.List;

import net.Placement_Manage_System.springboot.model.User;

public interface UserService {
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(long id);
	User updateUser(User user, long id);
	void deleteUser(long id);
}
