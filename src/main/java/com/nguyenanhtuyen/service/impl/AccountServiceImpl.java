package com.nguyenanhtuyen.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nguyenanhtuyen.model.AppUser;
import com.nguyenanhtuyen.model.Role;
import com.nguyenanhtuyen.repository.AppUserRepository;
import com.nguyenanhtuyen.repository.RoleRepository;
import com.nguyenanhtuyen.service.AccountService;
import com.nguyenanhtuyen.util.EmailConstructor;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountService accountService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AppUserRepository appUserRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private EmailConstructor emailConstructor;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	@Transactional
	public void saveUser(AppUser appUser) {
		String password = RandomStringUtils.randomAlphanumeric(10);
		String encryptedPassword = bCryptPasswordEncoder.encode(password);
		appUser.setPassword(encryptedPassword);
		appUserRepo.save(appUser);
		mailSender.send(emailConstructor.constructNewUserEmail(appUser, password));
	}

	@Override
	public AppUser findByUsername(String username) {
		return appUserRepo.findByUsername(username);
	}

	@Override
	public AppUser findByEmail(String email) {
		return appUserRepo.findByEmail(email);
	}

	@Override
	public List<AppUser> userList() {
		return appUserRepo.findAll();
	}

	@Override
	public Role findUserRoleByName(String name) {
		return roleRepo.findRoleByName(name);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public void updateUser(AppUser appUser) {
		String password = appUser.getPassword();
		String encryptedPassword = bCryptPasswordEncoder.encode(password);
		appUser.setPassword(encryptedPassword);
		appUserRepo.save(appUser);
		mailSender.send(emailConstructor.constructUpdateUserProfileEmail(appUser));
	}

	@Override
	public AppUser findById(Integer id) {
		return appUserRepo.findUserById(id);
	}

	@Override
	public void deleteUser(AppUser appUser) {
		appUserRepo.delete(appUser);
	}

	@Override
	public void resetPassword(AppUser appUser) {
		String password = appUser.getPassword();
		String encryptedPassword = bCryptPasswordEncoder.encode(password);
		appUser.setPassword(encryptedPassword);
		appUserRepo.save(appUser);
		mailSender.send(emailConstructor.constructResetPasswordEmail(appUser, password));
	}

	@Override
	public List<AppUser> getUserListByUsername(String username) {
		return appUserRepo.findByUsernameContaining(username);
	}

	@Override
	public AppUser simpleSave(AppUser appUser) {
		appUserRepo.save(appUser);
		mailSender.send(emailConstructor.constructUpdateUserProfileEmail(appUser));
		return appUser;
	}

}
