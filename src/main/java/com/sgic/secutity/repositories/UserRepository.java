package com.sgic.secutity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.secutity.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

	User findByEmail(String email);

}
