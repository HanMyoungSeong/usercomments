package kr.ac.jejuuniv.service.user;

import kr.ac.jejuuniv.model.User;

public interface UserService {

	User findByUserName(String username);

	void addMemeber(User user);

}
