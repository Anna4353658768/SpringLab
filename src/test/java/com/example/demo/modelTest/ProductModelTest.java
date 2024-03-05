package com.example.demo.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.example.demo.model.Manufacturer;
import com.example.demo.model.Product;

public class ProductModelTest {

	@InjectMocks
    private Product product;
	private Manufacturer manufacturer;
	
	
    @BeforeEach
    void setUp() {
    	product = new Product();
    	manufacturer = new Manufacturer();
    }

    
    @Test
    void testProductId() {
        Long id = 1L;
        product.setId(id);
        assertEquals(id, product.getId());
    }
	
    
    @Test
    void testProductName() {
        String name = "Молоко";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    
    @Test
    void testProductWeight() {
        Float weight = 4F;
        product.setWeight(weight);
        assertEquals(weight, product.getWeight());
    }
    
    
    @Test
    void testProductWidth() {
        Float width = 3F;
        product.setWidth(width);
        assertEquals(width, product.getWidth());
    }
    
    
    @Test
    void testProductHeight() {
        Float height = 2F;
        product.setHeight(height);
        assertEquals(height, product.getHeight());
    }
    
    
    @Test
    void testProductLength() {
        Float length = 10F;
        product.setLength(length);
        assertEquals(length, product.getLength());
    }
	
    
    @Test
    void testProductManufacturerid() {
    	Manufacturer manufacturerid = manufacturer;
        product.setManufacturerid(manufacturerid);
        assertEquals(manufacturerid, product.getManufacturerid());
    }
    
}












