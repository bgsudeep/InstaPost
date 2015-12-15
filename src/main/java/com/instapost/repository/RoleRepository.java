package com.instapost.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.instapost.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
