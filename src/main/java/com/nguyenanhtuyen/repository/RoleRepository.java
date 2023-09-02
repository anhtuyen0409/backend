package com.nguyenanhtuyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenanhtuyen.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	public Role findRoleByName(String name);
	
}
