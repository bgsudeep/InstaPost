package com.instapost.service;

import java.util.List;

import com.instapost.domain.User;

public interface UserService {

	public void save(User user);
	public List<User> findAll();
	public User findById(long id);
	public User findUserByEmail(String email);
	public void delete(User user);	
}
