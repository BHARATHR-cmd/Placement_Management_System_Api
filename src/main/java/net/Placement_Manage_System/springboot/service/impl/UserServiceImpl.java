package net.Placement_Manage_System.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.Placement_Manage_System.springboot.exception.ResourceNotFoundException;
import net.Placement_Manage_System.springboot.model.User;
import net.Placement_Manage_System.springboot.repository.UserRepository;
import net.Placement_Manage_System.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
//		Optional<User> user = userRepository.findById(id);
//		if(user.isPresent()) {
//			return user.get();
//		}else {
//			throw new ResourceNotFoundException("User", "Id", id);
//		}
		return userRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("User", "Id", id));
		
	}

	@Override
	public User updateUser(User user, long id) {
		
		// we need to check whether user with given id is exist in DB or not
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User", "Id", id)); 
		
		existingUser.setName(user.getName());
		existingUser.setPassword(user.getPassword());
		existingUser.setType(user.getType());
		
		
		
		// save existing user to DB
		userRepository.save(existingUser);
		return existingUser;
	}

	@Override
	public void deleteUser(long id) {
		
		// check whether a user exist in a DB or not
		userRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("User", "Id", id));
		userRepository.deleteById(id);
	}
	
}
