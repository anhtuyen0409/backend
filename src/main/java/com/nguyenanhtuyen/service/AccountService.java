package com.nguyenanhtuyen.service;

import java.util.List;

import com.nguyenanhtuyen.model.AppUser;
import com.nguyenanhtuyen.model.Role;

public interface AccountService {

	public void saveUser(AppUser appUser);
	
	public AppUser findByUsername(String username);
	
	public AppUser findByEmail(String email);
	
	public List<AppUser> userList();
	
	public Role findUserRoleByName(String role);
	
	public Role saveRole(Role role);
	
	public void updateUser(AppUser appUser);
	
	public AppUser findById(Integer id);
	
	public void deleteUser(AppUser appUser);
	
	public void resetPassword(AppUser appUser);
	
	public List<AppUser> getUserListByUsername(String username);
	
	public AppUser simpleSave(AppUser appUser);
	
}
