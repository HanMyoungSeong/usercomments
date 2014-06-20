package kr.ac.jejuuniv.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.Comment;

@Repository
public interface CommentRepository {

	Comment get(int id);

	void insert(Comment comment);

	void delete(int commentId);

	List<Comment> getAll();

	void recommend(int commentId);

	void oppose(int commentId);
}