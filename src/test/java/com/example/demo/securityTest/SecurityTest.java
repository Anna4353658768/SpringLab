package com.example.demo.securityTest;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
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
    public void givenBaseRole_whenGetLogin_thenOk() throws Exception{
    	mockMvcBase.perform(get("/login"))
    		.andExpect(status().isOk());
    }
    
    
    @Test
    public void givenBaseRole_whenGetRegister_thenOk() throws Exception{
    	mockMvcBase.perform(get("/register"))
    		.andExpect(status().isOk());
    }
    
    
    @Test
    public void givenBaseRole_whenGetManufacturers_thenRedirection() throws Exception{
    	mockMvcBase.perform(get("/manufacturers"))
    		.andExpect(status().is3xxRedirection());
    }
    
    
    @Test
    public void givenBaseRole_whenGetProducts_thenRedirection() throws Exception{
    	mockMvcBase.perform(get("/products"))
    		.andExpect(status().is3xxRedirection());
    }
    
    
    //Тесты для авторизованного пользователя
    @Test
    @WithMockUser(roles = "USER")
    void givenUserRole_whenGetLiveness_thenOk() throws Exception {
    	mockMvcUser.perform(get("/"))
    		.andExpect(status().isOk());
    }
    
    
    @Test
    @WithMockUser(roles = "USER")
    public void givenUserRole_whenGetManufacturers_thenOk() throws Exception{
    	mockMvcUser.perform(get("/manufacturers"))
    		.andExpect(status().isOk());
    }
    
    
    @Test
    @WithMockUser(roles = "USER")
    public void givenUserRole_whenGetProducts_thenOk() throws Exception{
    	mockMvcUser.perform(get("/products"))
    		.andExpect(status().isOk());
    }
    
    
    @Test
    @WithMockUser(roles = "USER")
    public void givenUserRole_whenGetLogin_thenOk() throws Exception{
    	mockMvcUser.perform(get("/login"))
    		.andExpect(status().isOk());
    }
    
    
    @Test
    @WithMockUser(roles = "USER")
    public void givenUserRole_whenGetRegister_thenOk() throws Exception{
    	mockMvcUser.perform(get("/register"))
    		.andExpect(status().isOk());
    }
    
    
}









