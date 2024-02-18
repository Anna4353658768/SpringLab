package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column(name = "name")
	@NotEmpty(message = "Вы должны ввести название продукта")
	private String name;
	
	
	@Column(name = "weight")
	@NotNull(message = "Вы должны ввести вес продукта")
	private Float weight;
	
	
	@Column(name = "width")
	@NotNull(message = "Вы должны ввести ширину продукта")
	private Float width;
	
	
	@Column(name = "height")
	@NotNull(message = "Вы должны ввести высоту продукта")
	private Float height;
	
	
	@Column(name = "length")
	@NotNull(message = "Вы должны ввести длину продукта")
	private Float length;
	
	
    @ManyToOne
    @JoinColumn(name = "manufacturerid")
    @NotNull(message = "Вы должны выбрать производителя")
    private Manufacturer manufacturerid;
    
}



