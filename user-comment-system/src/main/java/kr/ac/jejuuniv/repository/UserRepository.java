package kr.ac.jejuuniv.repository;

import kr.ac.jejuuniv.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	User get(String username);

	void insert(User user);
}
