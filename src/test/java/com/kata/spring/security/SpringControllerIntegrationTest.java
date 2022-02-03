package com.kata.spring.security;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@WebAppConfiguration
public class SpringControllerIntegrationTest {

	@Autowired
	MockMvc mockMvc ;
	
	@Test
	public void shouldReturnHellowhenSayHelloIsCalled_WithAuthToken() throws Exception {
		
		mockMvc.perform(get("/sayHello").header("auth-token", "abc")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturn403whenSayHelloIsCalled_WithInvalidAuthToken() throws Exception {
		
		mockMvc.perform(get("/sayHello").header("auth-token", "def")).andExpect(status().isForbidden());
	}
	
	@Test
	public void shouldReturnHellowhenSayHelloIsCalled_WithBearerToken() throws Exception {
		
		mockMvc.perform(get("/sayHello").header("Authorization", "xyz")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturn403whenSayHelloIsCalled_WithInvalidBearerToken() throws Exception {
		
		mockMvc.perform(get("/sayHello").header("Authorization", "wxy")).andExpect(status().isForbidden());
	}
	
	@Test
	public void shouldReturn403whenSayHelloIsCalled_WithInvalidHeader() throws Exception {
		
		mockMvc.perform(get("/sayHello").header("invalid-header", "wxy")).andExpect(status().isForbidden());
	}
}
