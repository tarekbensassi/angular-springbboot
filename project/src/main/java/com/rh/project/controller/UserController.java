package com.rh.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.rh.project.entity.User;
import com.rh.project.repository.UserRepository;



@CrossOrigin(origins = "http://localhost:9091")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/chefs")
	public ResponseEntity<List<User>> getAllChefs() {
		try {
			List<User> users =	userRepository.findAll();
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/chefs/{id}")
	public ResponseEntity<User> getchefById(@PathVariable("id") long id) {
		Optional<User> chefData = userRepository.findById(id);

		if (chefData.isPresent()) {
			return new ResponseEntity<>(chefData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/chefs")
	public ResponseEntity<User> createchef(@RequestBody User chef) {
		try {
			User _chef = userRepository.save(chef);
			return new ResponseEntity<>(_chef, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/chefs/{id}")
	public ResponseEntity<User> updatechef(@PathVariable("id") long id, @RequestBody User chef) {
		
		Optional<User> chefData = userRepository.findById(id);

		if (chefData.isPresent()) {
	
			
			return new ResponseEntity<>(userRepository.save(chef), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}




}
