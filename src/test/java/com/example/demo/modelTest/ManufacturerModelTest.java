package com.example.demo.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.example.demo.model.Manufacturer;

public class ManufacturerModelTest {

	@InjectMocks
    private Manufacturer manufacturer;

	
    @BeforeEach
    void setUp() {
        manufacturer = new Manufacturer();
    }

    
    @Test
    void testManufacturerId() {
        Long id = 1L;
        manufacturer.setId(id);
        assertEquals(id, manufacturer.getId());
    }

    
    @Test
    void testManufacturerName() {
        String name = "ООО ПрофТест";
        manufacturer.setName(name);
        assertEquals(name, manufacturer.getName());
    }

    
    @Test
    void testManufacturerCountry() {
        String country = "Россия";
        manufacturer.setCountry(country);
        assertEquals(country, manufacturer.getCountry());
    }

    
    @Test
    void testManufacturerPerson() {
        String person = "Попова Анна Евгеньевна";
        manufacturer.setPerson(person);
        assertEquals(person, manufacturer.getPerson());
    }

    
    @Test
    void testManufacturerPhone() {
        String phone = "+7 (123) 566-78-90";
        manufacturer.setPhone(phone);
        assertEquals(phone, manufacturer.getPhone());
    }
	
}
