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

import net.Placement_Manage_System.springboot.model.College;
import net.Placement_Manage_System.springboot.service.CollegeService;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {
	
	private CollegeService collegeService;

	public CollegeController(CollegeService collegeService) {
		super();
		this.collegeService = collegeService;
	}
	
	// build create college REST API
	@PostMapping()
	public ResponseEntity<College> saveCollege(@RequestBody College college){
		return new ResponseEntity<College>(collegeService.saveCollege(college), HttpStatus.CREATED);
	}
	
	// build get all colleges REST API
	@GetMapping
	public List<College> getAllColleges(){
		return collegeService.getAllColleges();
	}
	
	// build get college by id REST API
	// http://localhost:8080/api/colleges/1
	@GetMapping("{id}")
	public ResponseEntity<College> getCollegeById(@PathVariable("id") long collegeId){
		return new ResponseEntity<College>(collegeService.getCollegeById(collegeId), HttpStatus.OK);
	}
	
	// build update college REST API
	// http://localhost:8080/api/colleges/1
	@PutMapping("{id}")
	public ResponseEntity<College> updateCollege(@PathVariable("id") long id
												  ,@RequestBody College college){
		return new ResponseEntity<College>(collegeService.updateCollege(college, id), HttpStatus.OK);
	}
	
	// build delete college REST API
	// http://localhost:8080/api/colleges/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCollege(@PathVariable("id") long id){
		
		// delete college from DB
		collegeService.deleteCollege(id);
		
		return new ResponseEntity<String>("College deleted successfully!.", HttpStatus.OK);
	}
	
}
