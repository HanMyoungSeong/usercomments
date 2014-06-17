package kr.ac.jejuuniv.service.comment;

import java.util.List;

import kr.ac.jejuuniv.model.Comment;

public interface CommentService {

	Comment findByCommentId(int commentId);

	void addComment(Comment comment);

	List<Comment> commentList();

	void deleteComment(int commentId);

	void addRecommend(int commentId);

	void addOpposition(int commentId);

}
