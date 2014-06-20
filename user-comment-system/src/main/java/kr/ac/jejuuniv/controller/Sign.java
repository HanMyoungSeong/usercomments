package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.ElectionMember;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.electionmember.ElectionMemberService;
import kr.ac.jejuuniv.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/sign")
public class Sign {

	@Autowired
	private UserService userService;

	@Autowired
	private ElectionMemberService electionMemberService;
	
	@RequestMapping
	@Transactional
	public String signIn(String userName, String password, HttpSession httpSession) {
		try {
			userService.addMemeber(new User(userName, password));
			User getUser = userService.findByUserName(userName);
			electionMemberService.addElectionMember(new ElectionMember(getUser.getId()));
			
		} catch (Exception e) {
			sessionUserLogin(userName, httpSession);
		} finally {
			sessionUserLogin(userName, httpSession);
		}
		return "redirect:addComment.jeju";
	}

	private void sessionUserLogin(String userName, HttpSession httpSession) {
		User getUser = userService.findByUserName(userName);
		httpSession.setAttribute("id", getUser.getId());
		httpSession.setAttribute("username", getUser.getUserName());
	}
}
