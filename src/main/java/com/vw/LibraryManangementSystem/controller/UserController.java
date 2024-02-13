package com.vw.LibraryManangementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vw.LibraryManangementSystem.entity.Book;
import com.vw.LibraryManangementSystem.entity.User;
import com.vw.LibraryManangementSystem.services.IssuedBookDetailsService;
import com.vw.LibraryManangementSystem.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private IssuedBookDetailsService issuedBookDetailsService;
	
	@GetMapping("/get")
	public List<User> getUsers() {
		return this.userService.getUsers();
	}
	@GetMapping("/getById/{userId}")
	public User getUserById(@PathVariable int userId) {
		return this.userService.getUserById(userId);
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> removeUserById(@PathVariable int userId) {
		return new ResponseEntity<>(this.userService.removeUser(userId), HttpStatus.OK);
	}
	
	@PostMapping("/issueBook/{userId}")
	public String issueBook(@RequestBody Book book, @PathVariable int userId) {
		
		User borrower = getUserById(userId);
		return this.issuedBookDetailsService.issueBook(book, borrower);
	}
}
