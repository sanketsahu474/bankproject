package com.example.service;

import com.example.model.User;


import com.example.model.users;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public void saveusers(users use);
	public users findByCardno(String cardno);
	
}
