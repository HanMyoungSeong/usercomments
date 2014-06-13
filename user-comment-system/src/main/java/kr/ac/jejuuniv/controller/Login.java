package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/login")
public class Login {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String login(User user) {
		try {
			userService.addMemeber(user);
			return "write.jeju";
		} catch (Exception e) {
			return "login";
		}
	}
}
