package com.studyapp.ocp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyapp.ocp.app.model.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
