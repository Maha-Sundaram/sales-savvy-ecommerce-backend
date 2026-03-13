package com.salessavvy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User extends BaseEntity {
	
	private String name;
	
	private String email;
	
	private String password;
	
	@ManyToOne
	private String role;
	
}
