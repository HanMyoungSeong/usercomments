package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.Comment;
import kr.ac.jejuuniv.service.comment.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment.json")
public class CommentList {

	@Autowired
	private CommentService commentService;

	@ResponseBody
	@RequestMapping
	public List<Comment> list() {
		return commentService.commentList();
	}
}
