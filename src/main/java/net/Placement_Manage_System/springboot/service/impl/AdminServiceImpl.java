package net.Placement_Manage_System.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.Placement_Manage_System.springboot.exception.ResourceNotFoundException;
import net.Placement_Manage_System.springboot.model.Admin;
import net.Placement_Manage_System.springboot.repository.AdminRepository;
import net.Placement_Manage_System.springboot.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	private AdminRepository adminRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(long id) {
//		Optional<Admin> admin = adminRepository.findById(id);
//		if(admin.isPresent()) {
//			return admin.get();
//		}else {
//			throw new ResourceNotFoundException("Admin", "Id", id);
//		}
		return adminRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Admin", "Id", id));
		
	}

	@Override
	public Admin updateAdmin(Admin admin, long id) {
		
		// we need to check whether admin with given id is exist in DB or not
		Admin existingAdmin = adminRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Admin", "Id", id)); 
		
		existingAdmin.setName(admin.getName());
		existingAdmin.setPassword(admin.getPassword());
		
		
		
		// save existing admin to DB
		adminRepository.save(existingAdmin);
		return existingAdmin;
	}

	@Override
	public void deleteAdmin(long id) {
		
		// check whether a admin exist in a DB or not
		adminRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Admin", "Id", id));
		adminRepository.deleteById(id);
	}
	
}
