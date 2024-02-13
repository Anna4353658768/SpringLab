package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "weight")
	private Float weight;
	
	@Column(name = "width")
	private Float width;
	
	@Column(name = "height")
	private Float height;
	
	@Column(name = "length")
	private Float length;
	
    @ManyToOne
    @JoinColumn(name = "manufacturerid")
	private Manufacturer manufacturerid;
}



