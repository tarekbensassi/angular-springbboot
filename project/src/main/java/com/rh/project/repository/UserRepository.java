package com.rh.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rh.project.entity.User;



public interface UserRepository extends JpaRepository< User, Long> {
  List< User> findByPublished(boolean published);

  List< User> findByTitleContaining(String title);
}
