package com.rh.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rh.project.entity.Role;



public interface RoleRepository extends JpaRepository<Role, Long> {

}
