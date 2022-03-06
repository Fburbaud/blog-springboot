package com.printemps.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.printemps.blog.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String username);

}
