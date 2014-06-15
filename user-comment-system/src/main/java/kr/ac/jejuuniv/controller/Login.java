package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("login")
@SessionAttributes("sessionUser")
public class Login {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String signIn(String userName, String password, User sessionUser) {
		try {
			userService.addMemeber(new User(userName, password));
		} catch (Exception e) {
			User getUser = userService.findByUserName(userName);
			sessionUser.setId(getUser.getId());
			sessionUser.setUserName(getUser.getUserName());
		}
		return "comments";
	}

}
