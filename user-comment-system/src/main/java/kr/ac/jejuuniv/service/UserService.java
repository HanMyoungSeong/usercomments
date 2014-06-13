package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.User;

public interface UserService {

	User findByUserName(String username);

	void addMemeber(User user);

}
