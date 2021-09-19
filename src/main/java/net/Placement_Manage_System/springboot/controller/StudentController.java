package net.Placement_Manage_System.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.Placement_Manage_System.springboot.model.User;
import net.Placement_Manage_System.springboot.service.UserService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private UserService userService;

	public StudentController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// build create user REST API
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
	
	// build get all users REST API
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	// build get user by id REST API
	// http://localhost:8080/api/users/1
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	// build update user REST API
	// http://localhost:8080/api/users/1
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id
												  ,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
	}
	
	// build delete user REST API
	// http://localhost:8080/api/users/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		
		// delete user from DB
		userService.deleteUser(id);
		
		return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
	}
	
}