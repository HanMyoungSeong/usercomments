package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.comment.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addRecommendation")
public class AddRecommendation {

	@Autowired
	private CommentService commentService;

	@RequestMapping
	public String addRecommendation(int commentId) {
		commentService.addRecommend(commentId);
		return "redirect:/comments.jeju";
	}

}
