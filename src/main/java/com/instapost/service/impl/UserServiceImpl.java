package com.instapost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instapost.domain.User;
import com.instapost.repository.UserRepository;
import com.instapost.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findById(long id) {
		return (User) userRepository.findOne(id);
	}

	@Override
	public User findByEmail(String email) {
		return (User) userRepository.findUserByEmail(email);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
}
