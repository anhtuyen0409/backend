package com.nguyenanhtuyen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenanhtuyen.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

	public AppUser findByUsername(String username);
	
	public AppUser findByEmail(String email);
	
	public AppUser findUserById(Integer id);
	
	public List<AppUser> findByUsernameContaining(String username);
	
}
