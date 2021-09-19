package net.Placement_Manage_System.springboot.service;

import java.util.List;

import net.Placement_Manage_System.springboot.model.Admin;

public interface AdminService {
	Admin saveAdmin(Admin admin);
	List<Admin> getAllAdmins();
	Admin getAdminById(long id);
	Admin updateAdmin(Admin admin, long id);
	void deleteAdmin(long id);
}
