package kr.ac.jejuuniv.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUserName(String username) {
		return userRepository.get(username);
	}

	@Override
	public void addMemeber(User user) {
		User addedUser = userRepository.get(user.getUserName());
		if (addedUser == null)
			userRepository.insert(user);
		else
			throw new IllegalArgumentException("user is already exist!!");
	}

}
