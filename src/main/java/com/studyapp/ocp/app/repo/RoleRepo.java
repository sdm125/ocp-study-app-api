package com.studyapp.ocp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studyapp.ocp.app.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String username);
}
