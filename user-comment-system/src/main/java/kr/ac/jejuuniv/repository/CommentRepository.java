package kr.ac.jejuuniv.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.Comment;

@Repository
public interface CommentRepository {

	Comment get(int id);

	void insert(Comment comment);

	List<Comment> getAll();

	void delete(int commentId);

}