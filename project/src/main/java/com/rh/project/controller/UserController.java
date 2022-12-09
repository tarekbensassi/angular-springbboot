package com.rh.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.rh.project.entity.*;
import com.rh.project.repository.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
    EquipeRepository equipeRepository;
	@Autowired
    RoleRepository roleRepository;

	@GetMapping("/chefs")
	public ResponseEntity<Object> getAllChefs() {
		try {
			List<User> users =	userRepository.findUserByRole(1L);
		return new ResponseEntity<Object>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/roles")
	public ResponseEntity<Object> getAllRoles() {
		try {
			List<Role> roles =	roleRepository.findAll();
		return new ResponseEntity<Object>(roles, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/chefs/{id}")
	public ResponseEntity<Object> getCHefById(@PathVariable("id") Long id) {
		try {
		
			User user = userRepository.findById(id).get();
			if(user != null) {
				return new ResponseEntity<Object>(user, HttpStatus.OK);				
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception ex) {
		
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/chefs")
	public ResponseEntity<User> createchef(@RequestBody User user) {
		try {
				Role role = roleRepository.findById(1L).get();
				user.setRoles(role);
				userRepository.save(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/equipes/{id}")
	public ResponseEntity<Object> createequipe(@PathVariable("id") Long id ,@RequestBody Equipe equipe) {
		try {
	            equipeRepository.save(equipe);
		
				User user = userRepository.findById(id).get();
				user.addEquipe(equipeRepository.findTopByOrderByIdDesc());
				userRepository.save(user);
			return new ResponseEntity<Object>(user, HttpStatus.CREATED);
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
