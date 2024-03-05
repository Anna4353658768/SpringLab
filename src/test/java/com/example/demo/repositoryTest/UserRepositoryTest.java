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

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@InjectMocks
	private User user;
	
	
	@BeforeEach
	public void setup() {
		user = User.builder()
				.username("Анна")
				.password("12345")
				.fullname("Анна Попова")
				.street("Большая садовая")
				.city("Ростов-на-Дону")
				.state("Ростовская область")
				.zip("344023")
				.phoneNumber("89185663478")
				.build();
	}

	
	@DisplayName("JUnit test for save user operation")
	@Test
	public void givenUserObject_whenSave_thenReturnSavedUser() {
		
		User user = User.builder()
				.username("Анна")
				.password("12345")
				.fullname("Анна Попова")
				.street("Большая садовая")
				.city("Ростов-на-Дону")
				.state("Ростовская область")
				.zip("344023")
				.phoneNumber("89185663478")
				.build();

		User savedUser = userRepository.save(user);
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	

	@DisplayName("JUnit test for get all users operation")
	@Test
	public void givenUserList_whenFindAll_thenReturnUsersList() {
		
		User user1 = User.builder()
				.username("Анна")
				.password("12345")
				.fullname("Анна Попова")
				.street("Большая садовая")
				.city("Ростов-на-Дону")
				.state("Ростовская область")
				.zip("344023")
				.phoneNumber("89185663478")
				.build();
		
		Integer listSize = userRepository.findAll().size();
		userRepository.save(user);
		userRepository.save(user1);

		List<User> userList = userRepository.findAll();

		assertThat(userList).isNotNull();
		assertThat(userList.size()).isEqualTo(listSize + 2);
	}
	

	@DisplayName("JUnit test for get user by id operation")
	@Test
	public void givenUserObject_whenFindById_thenReturnUserObject() {
		
		userRepository.save(user);
		
		User userDB = userRepository.findById(user.getId()).get();

		assertThat(userDB).isNotNull();
	}

	
	@DisplayName("JUnit test for update user operation")
	@Test
	public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser() {
		
		userRepository.save(user);

		User savedUser = userRepository.findById(user.getId()).get();

		assertThat(savedUser.getUsername()).isEqualTo("Анна");
		assertThat(savedUser.getPassword()).isEqualTo("12345");
		assertThat(savedUser.getFullname()).isEqualTo("Анна Попова");
		assertThat(savedUser.getStreet()).isEqualTo("Большая садовая");
		assertThat(savedUser.getCity()).isEqualTo("Ростов-на-Дону");
		assertThat(savedUser.getState()).isEqualTo("Ростовская область");
		assertThat(savedUser.getZip()).isEqualTo("344023");
		assertThat(savedUser.getPhoneNumber()).isEqualTo("89185663478");
	}

	
	@DisplayName("JUnit test for delete user operation")
	@Test
	public void givenUserObject_whenDelete_thenRemoveUser() {
		
		userRepository.save(user);

		userRepository.deleteById(user.getId());
        Optional<User> userOptional = userRepository.findById(user.getId());

        assertThat(userOptional).isEmpty();
	}
	
}
