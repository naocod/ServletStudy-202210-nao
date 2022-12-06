package com.study.service;

 
import com.study.domain.User;
import com.study.repository.UserRepository;

public class AccountService {
	
	private static AccountService instance = null;
	
	private AccountService() {}
	
	public static AccountService getInstance() {
		if(instance == null) {
			instance = new AccountService();
		}
		return instance;
	}
	
	public boolean isDuplicateUsername(String username) {
		User user = UserRepository.getInstance().findUserByUsername(username);
		
		return user != null; // null이 아니어야지 true > 중복됨
		// null > false
		
	}
	
	public void register(User user) {
		UserRepository.getInstance().saveUser(user);
	}
	
	public User loadUserByUsername(String username) {
		return UserRepository.getInstance().findUserByUsername(username);
	}
	
	public boolean checkPassword(User user, String password) {
		return user.getPassword().equals(password);
	}

}
