package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			User user = userRepo.findByUsername(username);
			if (user != null) return user;
			throw new UsernameNotFoundException("User ‘" + username + "’ not found");
		};
		
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/", "/login", "/css/**", "images/**", "/register").permitAll()
				.requestMatchers("products/**", "manufacturers/**").authenticated()
				)
		
				.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
						.loginPage("/login")
				);
		
		return http.build();
	}
    
}










