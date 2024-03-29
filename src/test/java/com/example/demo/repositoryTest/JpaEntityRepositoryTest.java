package com.example.demo.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.repository.ManufacturerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

import jakarta.persistence.EntityManager;


@DataJpaTest
public class JpaEntityRepositoryTest {

    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private EntityManager entityManager;
    @Autowired private UserRepository userRepository;
    @Autowired private ManufacturerRepository manufacturerRepository;
    @Autowired private ProductRepository productRepository;
    
    
    @Test
    void injectedComponentsAreNotNull(){
         assertThat(dataSource).isNotNull();
         assertThat(jdbcTemplate).isNotNull();
         assertThat(entityManager).isNotNull();
         assertThat(userRepository).isNotNull();
         assertThat(manufacturerRepository).isNotNull();
         assertThat(productRepository).isNotNull();  
    }
	
}

