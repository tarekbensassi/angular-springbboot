package com.rh.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rh.project.entity.Equipe;



public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	Equipe findTopByOrderByIdDesc();

}
