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
import com.example.demo.repository.ManufacturerRepository;

@DataJpaTest
public class ManufacturerRepositoryTests {

	@Autowired private ManufacturerRepository manufacturerRepository;
	
	@InjectMocks
	private Manufacturer manufacturer;
	
	
    @BeforeEach
    public void setup(){
    	manufacturer = Manufacturer.builder()
                .name("ООО ПрофТест")
                .country("Россия")
                .person("Попова Анна Евгеньевна")
                .phone("+7 (123) 566-78-90")
                .build();
    }
    
    
    // JUnit test for save manufacturer operation
    @DisplayName("JUnit test for save manufacturer operation")
    @Test
    public void givenManufacturerObject_whenSave_thenReturnSavedManufacturer(){

    	Manufacturer manufacturer = Manufacturer.builder()
                .name("ООО ПрофТест")
                .country("Россия")
                .person("Попова Анна Евгеньевна")
                .phone("+7 (123) 566-78-90")
                .build();

        Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);
        assertThat(savedManufacturer).isNotNull();
        assertThat(savedManufacturer.getId()).isGreaterThan(0);
    }
    
    
    // JUnit test for get all manufacturer operation
    @DisplayName("JUnit test for get all manufacturer operation")
    @Test
    public void givenManufacturerList_whenFindAll_thenManufacturersList(){

    	Manufacturer manufacturer1 = Manufacturer.builder()
                .name("ООО СуперЛавка")
                .country("Абхазия")
                .person("Ковалев Дмитрий Владимирович")
                .phone("+7 (333) 222-333-46")
                .build();
    	
    	Integer listSize = manufacturerRepository.findAll().size();
    	manufacturerRepository.save(manufacturer);
    	manufacturerRepository.save(manufacturer1);

        List<Manufacturer> manufacturerList = manufacturerRepository.findAll();

        assertThat(manufacturerList).isNotNull();
        assertThat(manufacturerList.size()).isEqualTo(listSize + 2);
    }
    
    
    // JUnit test for get manufacturer by id operation
    @DisplayName("JUnit test for get manufacturer by id operation")
    @Test
    public void givenManufacturerObject_whenFindById_thenReturnManufacturerObject(){

    	manufacturerRepository.save(manufacturer);
    	
    	Manufacturer manufacturerDB = manufacturerRepository.findById(manufacturer.getId()).get();
    	
        assertThat(manufacturerDB).isNotNull();
    }
    
    
    // JUnit test for update manufacturer operation
    @DisplayName("JUnit test for update manufacturer operation")
    @Test
    public void givenManufacturerObject_whenUpdateManufacturer_thenReturnUpdatedManufacturer(){

    	manufacturerRepository.save(manufacturer);

    	Manufacturer savedManufacturer = manufacturerRepository.findById(manufacturer.getId()).get();
    	savedManufacturer.setName("ООО ОнлайнТест");
    	savedManufacturer.setCountry("Казахстан");
    	savedManufacturer.setPerson("Иванов Иван Иванович");
    	savedManufacturer.setPhone("+7 (445) 875-33-54");
    	Manufacturer updatedManufacturer =  manufacturerRepository.save(savedManufacturer);

        assertThat(updatedManufacturer.getName()).isEqualTo("ООО ОнлайнТест");
        assertThat(updatedManufacturer.getCountry()).isEqualTo("Казахстан");
        assertThat(updatedManufacturer.getPerson()).isEqualTo("Иванов Иван Иванович");
        assertThat(updatedManufacturer.getPhone()).isEqualTo("+7 (445) 875-33-54");
    }
    
    
    // JUnit test for delete manufacturer operation
    @DisplayName("JUnit test for delete manufacturer operation")
    @Test
    public void givenManufacturerObject_whenDelete_thenRemoveManufacturer(){

    	manufacturerRepository.save(manufacturer);

    	manufacturerRepository.deleteById(manufacturer.getId());
        Optional<Manufacturer> manufacturerOptional = manufacturerRepository.findById(manufacturer.getId());

        assertThat(manufacturerOptional).isEmpty();
    }
    
}













