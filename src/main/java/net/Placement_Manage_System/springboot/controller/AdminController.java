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

import net.Placement_Manage_System.springboot.model.Admin;
import net.Placement_Manage_System.springboot.service.AdminService;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
	
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	// build create admin REST API
	@PostMapping()
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
	}
	
	// build get all admins REST API
	@GetMapping
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	// build get admin by id REST API
	// http://localhost:8080/api/admins/1
	@GetMapping("{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") long adminId){
		return new ResponseEntity<Admin>(adminService.getAdminById(adminId), HttpStatus.OK);
	}
	
	// build update admin REST API
	// http://localhost:8080/api/admins/1
	@PutMapping("{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable("id") long id
												  ,@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.updateAdmin(admin, id), HttpStatus.OK);
	}
	
	// build delete admin REST API
	// http://localhost:8080/api/admins/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") long id){
		
		// delete admin from DB
		adminService.deleteAdmin(id);
		
		return new ResponseEntity<String>("Admin deleted successfully!.", HttpStatus.OK);
	}
	
}
