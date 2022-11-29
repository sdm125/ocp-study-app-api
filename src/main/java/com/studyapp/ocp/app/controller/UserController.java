package com.studyapp.ocp.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studyapp.ocp.app.model.AppUser;
import com.studyapp.ocp.app.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<AppUser>> getUsers() {
		return ResponseEntity.ok().body(userService.getUsers());
	}
}
