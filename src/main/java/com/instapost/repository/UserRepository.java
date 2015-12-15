package com.instapost.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.instapost.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	@Query("select u from USER u where u.email=:email")
	public User findUserByEmail(@Param("email") String email);
}
