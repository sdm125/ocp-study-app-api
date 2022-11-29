package com.studyapp.ocp.app.service;

import java.util.List;

import com.studyapp.ocp.app.model.AppUser;
import com.studyapp.ocp.app.model.Role;

public interface UserService {
	AppUser saveUser(AppUser user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String role);
	AppUser getUser(String username);
	List<AppUser> getUsers();
}
