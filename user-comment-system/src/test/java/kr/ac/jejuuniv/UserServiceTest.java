package kr.ac.jejuuniv;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Random;

import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:kr/ac/jejuuniv/repository/test-mybatis-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	private static final int
	ID = 2;
	
	private static final String
	USERNAME = "testname3";
	
	private static final String
	PASSWORD = "1q2w3e";

	@Test
	public void //
	should_return_matched_result_when_user_is_member() {
		User getUser = userService.findByUserName(USERNAME);
		assertThat(getUser.getId(), is(ID));
		assertThat(getUser.getUserName(), is(USERNAME));
		assertThat(getUser.getPassword(), is(PASSWORD));
	}

	@Test
	public void //
	should_add_user_when_user_is_not_member() {
		String addUserName = "testname" + String.valueOf(new Random().nextInt());
		User user = new User(addUserName, PASSWORD);

		userService.addMemeber(user);

		User addedUser = userService.findByUserName(USERNAME);
		assertThat(addedUser.getId(), is(ID));
		assertThat(addedUser.getUserName(), is(USERNAME));
		assertThat(addedUser.getPassword(), is(PASSWORD));
	}

	@Test(expected = IllegalArgumentException.class)
	public void //
	should_throw_an_exception_when_the_added_user_is_already_exist() {
		User user = new User(USERNAME, PASSWORD);
		userService.addMemeber(user);
	}

}