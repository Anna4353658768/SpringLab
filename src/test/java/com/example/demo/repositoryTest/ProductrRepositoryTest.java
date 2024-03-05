package com.example.demo.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Manufacturer;
import com.example.demo.model.Product;
import com.example.demo.repository.ManufacturerRepository;
import com.example.demo.repository.ProductRepository;

@DataJpaTest
public class ProductrRepositoryTest {

	@Autowired private ProductRepository productRepository;
	@Autowired private ManufacturerRepository manufacturerRepository;
	
	@InjectMocks
	private Product product;
	
	private Manufacturer manufacturer;
	
	
    @BeforeEach
    public void setup(){
    	
    	manufacturer = Manufacturer.builder()
                .name("ООО ПрофТест")
                .country("Россия")
                .person("Попова Анна Евгеньевна")
                .phone("+7 (123) 566-78-90")
                .build();
    	
    	manufacturerRepository.save(manufacturer);
    	
    	product = Product.builder()
                .name("ООО ПрофТест")
                .weight(5F)
                .width(5F)
                .height(5F)
                .length(5F)
                .manufacturerid(manufacturer)
                .build();
    }
	
    
    @DisplayName("JUnit test for save product operation")
    @Test
    public void givenProductObject_whenSave_thenReturnSavedProduct(){

    	Product product = Product.builder()
                .name("ООО ПрофТест")
                .weight(5F)
                .width(5F)
                .height(5F)
                .length(5F)
                .manufacturerid(manufacturer)
                .build();

    	Product savedProduct = productRepository.save(product);
        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }
	
    
    // JUnit test for get all product operation
    @DisplayName("JUnit test for get all product operation")
    @Test
    public void givenProductList_whenFindAll_thenProductList(){

    	Product product1 = Product.builder()
                .name("ООО НовыйТест")
                .weight(1F)
                .width(1F)
                .height(1F)
                .length(1F)
                .manufacturerid(manufacturer)
                .build();
    	
    	Integer listSize = productRepository.findAll().size();
    	productRepository.save(product);
    	productRepository.save(product1);

        List<Product> productList = productRepository.findAll();

        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(listSize + 2);
    }
    
    
    // JUnit test for get product by id operation
    @DisplayName("JUnit test for get product by id operation")
    @Test
    public void givenProductObject_whenFindById_thenReturnProductObject(){

    	productRepository.save(product);
    	
    	Product productDB = productRepository.findById(product.getId()).get();
    	
        assertThat(productDB).isNotNull();
    }
    
    
    // JUnit test for update product operation
    @DisplayName("JUnit test for update product operation")
    @Test
    public void givenProductObject_whenUpdateProduct_thenReturnUpdatedProduct(){

    	productRepository.save(product);

    	Product savedProduct = productRepository.findById(product.getId()).get();
    	savedProduct.setName("ООО ОнлайнТест");
    	savedProduct.setWeight(3F);
    	savedProduct.setWidth(3F);
    	savedProduct.setHeight(3F);
    	savedProduct.setLength(3F);
    	savedProduct.setManufacturerid(manufacturer);
    	
    	Product updatedProduct =  productRepository.save(savedProduct);

        assertThat(updatedProduct.getName()).isEqualTo("ООО ОнлайнТест");
        assertThat(updatedProduct.getWeight()).isEqualTo(3F);
        assertThat(updatedProduct.getWidth()).isEqualTo(3F);
        assertThat(updatedProduct.getHeight()).isEqualTo(3F);
        assertThat(updatedProduct.getLength()).isEqualTo(3F);
        assertThat(updatedProduct.getManufacturerid()).isEqualTo(manufacturer);
    }
    
    
    // JUnit test for delete product operation
    @DisplayName("JUnit test for delete product operation")
    @Test
    public void givenProductObject_whenDelete_thenRemoveProduct(){

    	productRepository.save(product);

    	productRepository.deleteById(product.getId());
        Optional<Product> productOptional = productRepository.findById(product.getId());

        assertThat(productOptional).isEmpty();
    }
}



















