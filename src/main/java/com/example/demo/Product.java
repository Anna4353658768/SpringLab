package com.example.demo;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Table("Products")
public class Product {
	
	@Id
	private String id;
	
	@NotNull
	@Size(min=3, message="Имя должно содержать не менее 3 символов")
	private String name;

	private Float weight;
	
	@NotNull
	@Size(min=1, message="Выберите производителя")
	private Manufacturer manufacturer;
	private Float width;
	private Float height;
	private Float length;
}



