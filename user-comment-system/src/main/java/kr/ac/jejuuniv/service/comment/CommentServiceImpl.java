package kr.ac.jejuuniv.service.comment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.ac.jejuuniv.model.Comment;
import kr.ac.jejuuniv.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment findByCommentId(int id) {
		return commentRepository.get(id);
	}

	@Override
	public void addComment(Comment comment) {
		comment.setDate(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
		comment.setTime(new SimpleDateFormat("hh:mm").format(new Date()));
		commentRepository.insert(comment);
	}

	@Override
	public List<Comment> commentList() {
		return commentRepository.getAll();
	}

	@Override
	public void deleteComment(int commentId) {
		commentRepository.delete(commentId);
	}

	@Override
	public void addRecommend(int commentId) {
		commentRepository.recommend(commentId);
	}

	@Override
	public void addOpposition(int commentId) {
		commentRepository.oppose(commentId);
	}

}
