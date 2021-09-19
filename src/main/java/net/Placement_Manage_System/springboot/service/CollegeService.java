package net.Placement_Manage_System.springboot.service;

import java.util.List;

import net.Placement_Manage_System.springboot.model.College;

public interface CollegeService {
	College saveCollege(College college);
	List<College> getAllColleges();
	College getCollegeById(long id);
	College updateCollege(College college, long id);
	void deleteCollege(long id);
}
