package com.example.demo;

import lombok.Data;

import org.springframework.data.annotation.Id;

import com.example.demo.Manufacturer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "Products")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=3, message="Имя должно содержать не менее 3 символов")
	private String name;
	

	@NotNull
	@Size(min=1, message="Выберите производителя")
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturerid;
	
	private Float weight;
	private Float width;
	private Float height;
	private Float length;
}



