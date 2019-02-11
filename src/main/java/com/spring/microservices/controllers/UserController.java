package com.spring.microservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.microservices.entities.UserEntity;
import com.spring.microservices.services.UserService;

@Controller
@RequestMapping("/services/v1/")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<Object> saveUser(@RequestBody UserEntity userEntity) {
		userService.saveUser(userEntity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(userEntity.getUserId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("users")
	public @ResponseBody List<UserEntity> getAllUser() {
		return userService.findAllUser();
	}

	@GetMapping("/user/{userId}")
	public @ResponseBody UserEntity getUser(@PathVariable String userId) {
		return userService.findUserById(Integer.parseInt(userId));
	}

}
