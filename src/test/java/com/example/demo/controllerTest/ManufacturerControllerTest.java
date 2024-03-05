package com.example.demo.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.example.demo.controller.ManufacturerController;
import com.example.demo.repository.ManufacturerRepository;

@WebMvcTest(ManufacturerController.class)
public class ManufacturerControllerTest {

	@Autowired private MockMvc mockMvc;
	@Autowired private ManufacturerController controller;
	
    @MockBean private ManufacturerRepository manufacturerRepository;
    
    
	@Test
	@WithMockUser(roles = "USER")
	public void testHomePage() throws Exception {
		
		assertThat(controller).isNotNull();
		assertThat(mockMvc).isNotNull();
		
		mockMvc.perform(get("/manufacturers"))
		.andExpect(status().isOk())
		.andExpect(view().name("manufacturers"))
		.andExpect(content().string(
		containsString("Производители")));
		
	}
	
}
