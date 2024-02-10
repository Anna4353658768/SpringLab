package entity;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@Table("Products")
public class Product {
	
	@Id
	private Long id;
	
	@NotNull
	@Size(min=3, message="Имя должно содержать не менее 3 символов")
	private String name;
	
	@NotNull
	@Size(min=1, message="Выберите производителя")
	private Manufacturer manufacturer;
	
	private Float weight;
	private Float width;
	private Float height;
	private Float length;
}



