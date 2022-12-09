package com.rh.project.entity;

import java.util.Date;


import jakarta.persistence.*;

import lombok.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
