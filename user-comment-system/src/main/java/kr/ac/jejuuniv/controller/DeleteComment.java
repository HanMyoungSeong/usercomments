package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteComment")
public class DeleteComment {

	@Autowired
	private CommentService commentService;

	@RequestMapping
	public String delete(int commentId) {
		commentService.deleteComment(commentId);
		return "redirect:/comments.jeju";
	}
}
