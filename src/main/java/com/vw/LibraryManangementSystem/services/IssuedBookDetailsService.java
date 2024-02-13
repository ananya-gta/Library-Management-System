package com.vw.LibraryManangementSystem.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vw.LibraryManangementSystem.entity.Book;
import com.vw.LibraryManangementSystem.entity.IssuedBookDetails;
import com.vw.LibraryManangementSystem.entity.OverdueFee;
import com.vw.LibraryManangementSystem.entity.User;
import com.vw.LibraryManangementSystem.repository.BookRepo;
import com.vw.LibraryManangementSystem.repository.IssuedBookDetailsRepo;

@Service
public class IssuedBookDetailsService {

	@Autowired
	private IssuedBookDetailsRepo issuedBookDetailsRepo;
	
	@Autowired
	private BookRepo bookRepo;

	public String issueBook(Book book, User user) {
		
		IssuedBookDetails details = new IssuedBookDetails(book, user, new Date(), null, null);
		this.issuedBookDetailsRepo.save(details);
		// change availability status
		Book issuedBook = this.bookRepo.findById(book.getBookId()).get();
		issuedBook.setAvailable(false);
		this.bookRepo.save(issuedBook);
		return book.getTitle() + " issued by user : " + user.getName() + ". You should return the book by " + details.getExpectedReturnDate();
	}
}
