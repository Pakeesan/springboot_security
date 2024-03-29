package com.sgic.secutity.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sgic.secutity.entity.Role;
import com.sgic.secutity.entity.User;
import com.sgic.secutity.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole=new Role("USER");
		List<Role> roles=new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole=new Role("ADMIN");
		List<Role> roles=new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}
	public User findOne(String email) {
		return userRepository.findByEmail(email);
	}
	public boolean isUserPresent(String email) {
		User u=userRepository.findByEmail(email);
		if(u!=null)
			return true;
		return false;
	}
	public Object findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
}
