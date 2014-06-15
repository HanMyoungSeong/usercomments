package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.Comment;

public interface CommentService {

	Comment findByCommentId(int commentId);

	void addComment(Comment comment);

	List<Comment> commentList();

	void deleteComment(int commentId);

}
