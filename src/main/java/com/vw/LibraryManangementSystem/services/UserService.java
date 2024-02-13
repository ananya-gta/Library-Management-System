package com.vw.LibraryManangementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vw.LibraryManangementSystem.entity.User;
import com.vw.LibraryManangementSystem.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> getUsers() {
		return this.userRepo.findAll();
	}
	
	public List<User> getUserById(int userId) {
		return this.userRepo.findByUserId(userId);
	}

	public String addUser(User user) {
		this.userRepo.save(user);
		return "User added successfully";
	}

	public String removeUser(int userId) {
		this.userRepo.deleteById(userId);
		return "User removed successfully";
	}

}
