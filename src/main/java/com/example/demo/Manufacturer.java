package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table("Manufacturers")
public class Manufacturer {

	@Id
	private String id;
	
	@NotNull
	@Size(min=3, message="Имя должно содержать не менее 3 символов")
	private String name;
	
	private String country;
	private String person;
	private String phone;
	
}


