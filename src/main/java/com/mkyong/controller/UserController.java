package com.mkyong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.dao.RoleRepository;
import com.mkyong.dao.UserRepository;
import com.mkyong.dao.UserRoleRepository;
import com.mkyong.model.Role;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;

@RestController
public class UserController {
	
	@Autowired
	UserRoleRepository userRoleRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	
	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestParam String userName , @RequestParam String password ,@RequestParam Long role_id ){
		
		Role role = roleRepo.findOne(role_id);

		User user = new User();
		user.setUsername(userName);
		user.setPassword(encoder.encode(password));

		UserRole ur = new UserRole();
		ur.setRole(role);
		ur.setUser(user);
		
		user.getUserRoles().add(ur);
		user = userRepo.save(user);
		
		return new ResponseEntity<User>(user , HttpStatus.CREATED);
	}
	
}
