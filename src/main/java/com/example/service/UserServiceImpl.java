package com.example.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.User;

import com.example.model.users;
import com.example.repository.RoleRepository;

import com.example.repository.UserRepository;
import com.example.repository.usersRepository;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
	@Autowired
	private usersRepository useRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	@Override
	public void saveusers(users use) {

		use.setFirstname(use.getFirstname());
		use.setMiddlename(use.getFirstname());
		use.setLastname(use.getLastname());
		use.setCardno(use.getCardno());
		use.setBankname(use.getBankname());
		use.setCvv(use.getCvv());
		use.setValidfrom(use.getValidfrom());
		use.setExpiry(use.getExpiry());
		use.setCardtype(use.getCardtype());
		useRepository.save(use);
	}
	@Override
	public users  findByCardno(String cardno) {
		return useRepository.findByCardno(cardno);
	}
	
	
	

}
