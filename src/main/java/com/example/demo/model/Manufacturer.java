package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "manufacturers")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@Column(name = "name")
	@NotEmpty(message = "Вы должны ввести название производителя")
	private String name;
	
	
	@Column(name = "country")
	@NotEmpty(message = "Вы должны ввести название страны")
	private String country;
	
	
	@Column(name = "person")
	@NotEmpty(message = "Вы должны ввести контанкное лицо")
	private String person;
	
	
	@Column(name = "phone")
	@NotEmpty(message = "Вы должны ввести номер телефона")
	private String phone;
	
}


