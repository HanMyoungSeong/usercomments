package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.comment.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addOpposition")
public class AddOpposition {

	@Autowired
	private CommentService commentService;

	@RequestMapping
	public String addOpposition(int commentId) {
		commentService.addOpposition(commentId);
		return "redirect:/comments.jeju";
	}
}
