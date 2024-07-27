package edu.uh.nsm.cosc.eventmanager.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.jdbc.Sql;

import edu.uh.nsm.cosc.eventmanager.model.User;

@SpringBootTest
@Sql("/test-users.sql")
public class UserServiceIntegrationTest {

	@Autowired
	private UserService userService;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(userService).isNotNull();
	}

	@Test
	void testUser() {
		User user = userService.getUser(1L);
		
		assertThat(user.getId()).isEqualTo(1L);
	}
	
	@Test
	void registerUser() {
		User user = new User();
		user.setUsername("testUser1@test.com");
		user.setPassword("password");
		userService.registerUser(user);
	}
	
	@Test
	void loadUserByUsername() {
		User user = new User();
		user.setUsername("testUser2@test.com");
		user.setPassword("password");
		userService.registerUser(user);
		
		UserDetails foundUser = userService.loadUserByUsername("testUser2@test.com");
		assertThat(foundUser.getUsername()).isEqualTo("testUser2@test.com");
	}
	
	@Test
	void loadUserByUsernameException() {
		assertThrows(UsernameNotFoundException.class, () -> {userService.loadUserByUsername("notAuser@test.com");});
	}
}