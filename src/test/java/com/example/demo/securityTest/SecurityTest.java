package com.example.demo.securityTest;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityTest {

	@Autowired private WebApplicationContext context;
	@Autowired private MockMvc mockMvcBase;
	@Autowired private MockMvc mockMvcUser;

	
	@BeforeEach()
	public void setup(){
		
		mockMvcUser = MockMvcBuilders
	    		.webAppContextSetup(context)
	    		.build();
	    
		mockMvcBase = MockMvcBuilders
	            .webAppContextSetup(context)
	            .apply(springSecurity())  
	            .build();
	}
   
	//Тесты для неавторизованного пользователя
    @Test
    void givenUserIsAnonymous_whenGetLiveness_thenOk() throws Exception {
    	mockMvcBase.perform(get("/"))
    		.andExpect(status().isOk());
    }
    
    
    @Test
    public void givenBaseRole_whenGetManufacturers_thenOk() throws Exception{
    	mockMvcBase.perform(get("/manufacturers"))
    		.andExpect(status().is3xxRedirection());
    }
    
    
    //Тесты для авторизованного пользователя
    @Test
    public void givenUserRole_whenGetManufacturers_thenOk() throws Exception{
    	mockMvcUser.perform(get("/manufacturers"))
    		.andExpect(status().isOk());
    }
    
    
}








