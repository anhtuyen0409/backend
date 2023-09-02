package com.nguyenanhtuyen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nguyenanhtuyen.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

	public AppUser findByUsername(String username);
	
	public AppUser findByEmail(String email);
	
	@Query("SELECT appUser FROM AppUser appUser WHERE appUser.id =: x")
	public AppUser findUserById(@Param("x") Integer id);
	
	public List<AppUser> findByUsernameContaining(String username);
	
}
