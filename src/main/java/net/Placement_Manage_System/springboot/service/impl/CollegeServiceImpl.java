package net.Placement_Manage_System.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.Placement_Manage_System.springboot.exception.ResourceNotFoundException;
import net.Placement_Manage_System.springboot.model.College;
import net.Placement_Manage_System.springboot.repository.CollegeRepository;
import net.Placement_Manage_System.springboot.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService{

	private CollegeRepository collegeRepository;
	
	public CollegeServiceImpl(CollegeRepository collegeRepository) {
		super();
		this.collegeRepository = collegeRepository;
	}

	@Override
	public College saveCollege(College college) {
		return collegeRepository.save(college);
	}

	@Override
	public List<College> getAllColleges() {
		return collegeRepository.findAll();
	}

	@Override
	public College getCollegeById(long id) {
//		Optional<College> college = collegeRepository.findById(id);
//		if(college.isPresent()) {
//			return college.get();
//		}else {
//			throw new ResourceNotFoundException("College", "Id", id);
//		}
		return collegeRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("College", "Id", id));
		
	}

	@Override
	public College updateCollege(College college, long id) {
		
		// we need to check whether college with given id is exist in DB or not
		College existingCollege = collegeRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("College", "Id", id)); 
		
		existingCollege.setCollegeadmin(college.getCollegeadmin());
		existingCollege.setCollegename(college.getCollegename());
		existingCollege.setLocation(college.getLocation());
		
		
		// save existing college to DB
		collegeRepository.save(existingCollege);
		return existingCollege;
	}

	@Override
	public void deleteCollege(long id) {
		
		// check whether a college exist in a DB or not
		collegeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("College", "Id", id));
		collegeRepository.deleteById(id);
	}
	
}
