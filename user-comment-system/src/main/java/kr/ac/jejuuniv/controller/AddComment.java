package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.Comment;
import kr.ac.jejuuniv.model.ElectionMember;
import kr.ac.jejuuniv.service.comment.CommentService;
import kr.ac.jejuuniv.service.electionmember.ElectionMemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/writeComment")
public class AddComment {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping
	public String addComment(Comment comment, HttpSession httpSession) {
		comment.setId((Integer) httpSession.getAttribute("id"));
		comment.setAuthor((String) httpSession.getAttribute("username"));
		commentService.addComment(comment);
		return "redirect:/";
	}
}
