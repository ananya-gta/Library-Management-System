package com.vw.LibraryManangementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vw.LibraryManangementSystem.entity.Book;
import com.vw.LibraryManangementSystem.entity.IssuedBookDetails;
import com.vw.LibraryManangementSystem.entity.User;
import com.vw.LibraryManangementSystem.services.IssuedBookDetailsService;
import com.vw.LibraryManangementSystem.services.UserService;

@RestController
@RequestMapping("/issueBook")
public class IssueBookController {

	@Autowired
	private UserService userService;

	@Autowired
	private IssuedBookDetailsService issuedBookDetailsService;

	@PostMapping("/{userId}")
	public String issueBook(@RequestBody Book book, @PathVariable int userId) {
		User borrower = this.userService.getUserById(userId);
		return this.issuedBookDetailsService.issueBook(book, borrower);
	}

	@GetMapping("/getIssuedBookDetails")
	public List<IssuedBookDetails> getAllIssuedBookDetails() {
		return this.issuedBookDetailsService.getAllIssuedBookDetails();
	}
	
	@GetMapping("/returnBook/{issuedBookId}")
	public String returnBook(@PathVariable int issuedBookId) {
		return this.issuedBookDetailsService.returnBook(issuedBookId);
	}

}
