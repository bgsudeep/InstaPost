package com.instapost.service;

import java.util.List;

import com.instapost.domain.Role;

public interface RoleService {
	public Role getRoleById(long id);
	public void save(Role role);
	public List<Role> findAll();
	public void delete(Role role);
	
}
