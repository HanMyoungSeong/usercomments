package kr.ac.jejuuniv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Random;

import kr.ac.jejuuniv.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:kr/ac/jejuuniv/repository/test-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;
	private int id = 2;
	private String username = "testname3";
	private String password = "1q2w3e";

	@Test
	public void //
	should_return_matched_result_when_user_is_member() {
		User getUser = userService.findByUserName(this.username);

		assertThat(getUser.getId(), is(this.id));
		assertThat(getUser.getUserName(), is(this.username));
		assertThat(getUser.getPassword(), is(this.password));
	}

	@Test
	public void //
	should_add_user_when_user_is_not_member() {
		User user = new User();
		user.setUserName("testname" + String.valueOf(new Random().nextInt()));
		user.setPassword(password);

		userService.addMemeber(user);

		User addedUser = userService.findByUserName(this.username);

		assertThat(addedUser.getId(), is(this.id));
		assertThat(addedUser.getUserName(), is(this.username));
		assertThat(addedUser.getPassword(), is(this.password));

	}

	@Test(expected = IllegalArgumentException.class)
	public void //
	should_throw_an_exception_when_the_added_user_is_already_exist() {
		User user = new User();
		user.setUserName(this.username);
		user.setPassword(this.password);

		userService.addMemeber(user);
	}
}