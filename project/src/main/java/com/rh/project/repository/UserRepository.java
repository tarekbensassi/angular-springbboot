package com.rh.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rh.project.entity.Equipe;
import com.rh.project.entity.User;



public interface UserRepository extends JpaRepository< User, Long> {
  //List< User> findByPublished(boolean published);

 // List< User> findByTitleContaining(String title);
	 @Query("SELECT user FROM User user LEFT JOIN user.roles role WHERE role.id = ?1")
	 List<User> findUserByRole(Long role);
	 
	  List<Equipe> findEquipesById(Long userId);
}
