package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.service.comment.CommentService;
import kr.ac.jejuuniv.service.electionmember.ElectionMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addRecommendation")
public class AddRecommendation {

	@Autowired
	private CommentService commentService;

	@Autowired
	private ElectionMemberService electionMemberService;

	@RequestMapping
	public String addRecommendation(int commentId, HttpSession httpSession) {
		Integer userId = (Integer) httpSession.getAttribute("id");
		try {
			electionMemberService.addRecommend(userId);
			commentService.addRecommendation(commentId);
		} catch (Exception e) {
			return "redirect:/comments.jeju";
		}

		return "redirect:/comments.jeju";
	}
}
