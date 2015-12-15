package com.instapost.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.instapost.domain.Role;
import com.instapost.repository.RoleRepository;
import com.instapost.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role getRoleById(long id) {
		return (Role) roleRepository.findOne(id);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		return (List<Role>) roleRepository.findAll();
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}

}
