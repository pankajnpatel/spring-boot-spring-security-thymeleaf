package com.mkyong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.dao.RoleRepository;
import com.mkyong.model.Role;

@RestController
public class RoleController {
	
	@Autowired
	RoleRepository roleRepo;
	
	@PostMapping(value = "/role/add")
	public ResponseEntity<Role> addRole(@RequestBody Role role){
		role = roleRepo.save(role);
		return new ResponseEntity<Role>(role,HttpStatus.CREATED);
	}
	
}
