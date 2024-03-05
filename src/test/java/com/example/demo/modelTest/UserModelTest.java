package com.example.demo.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.User;

@SpringBootTest
public class UserModelTest {
	
	@InjectMocks
    private User user;
	
	
    @BeforeEach
    void setUp() {
    	user = User.builder()
                .fullname("Анна")
                .password("12345")
                .fullname("Попова Анна")
                .street("Большая садовая")
                .city("Ростов-на-Дону")
                .state("Ростовская область")
                .zip("344057")
                .phoneNumber("89185334509")
                .build();
    }
	
    
    @Test
    void testUsertId() {
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }
    
    
    @Test
    void testUsertPassword() {
        assertEquals("12345", user.getPassword());
    }
    
    
    @Test
    void testUsertFullname() {
        assertEquals("Попова Анна", user.getFullname());
    }
	
    
    @Test
    void testUsertStreet() {
        assertEquals("Большая садовая", user.getStreet());
    }
    
    
    @Test
    void testUsertCity() {
        assertEquals("Ростов-на-Дону", user.getCity());
    }
    
    
    @Test
    void testUsertState() {
        assertEquals("Ростовская область", user.getState());
    }
    
    
    @Test
    void testUsertZip() {
        assertEquals("344057", user.getZip());
    }
    
    
    @Test
    void testUsertPhoneNumber() {
        assertEquals("89185334509", user.getPhoneNumber());
    }

}











