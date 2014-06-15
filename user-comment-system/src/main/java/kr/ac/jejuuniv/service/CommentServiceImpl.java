package kr.ac.jejuuniv.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.ac.jejuuniv.Comment;
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
		String formatDate = simpleDateFormat.format(new Date());
		comment.setDate(formatDate);
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

}
