package com.studyapp.ocp.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studyapp.ocp.app.model.AppUser;
import com.studyapp.ocp.app.model.Role;
import com.studyapp.ocp.app.repo.RoleRepo;
import com.studyapp.ocp.app.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	
	@Override
	public AppUser saveUser(AppUser user) {
		log.info("Saving new user {} to database", user.getName());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role {} to database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Adding role {} to user {}", roleName, username);
		AppUser user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public AppUser getUser(String username) {
		log.info("Fetching user {}", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<AppUser> getUsers() {
		log.info("Fetching all users");
		return userRepo.findAll();
	}
	
}
