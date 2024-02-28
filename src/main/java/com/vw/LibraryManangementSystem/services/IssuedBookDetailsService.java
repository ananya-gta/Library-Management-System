package com.vw.LibraryManangementSystem.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import com.vw.LibraryManangementSystem.entity.Book;
import com.vw.LibraryManangementSystem.entity.IssuedBookDetails;
import com.vw.LibraryManangementSystem.entity.OverdueFee;
import com.vw.LibraryManangementSystem.entity.User;
import com.vw.LibraryManangementSystem.repository.BookRepo;
import com.vw.LibraryManangementSystem.repository.IssuedBookDetailsRepo;
import com.vw.LibraryManangementSystem.repository.OverdueFeeRepo;
import com.vw.LibraryManangementSystem.repository.UserRepo;

@Service
public class IssuedBookDetailsService {

	@Autowired
	private IssuedBookDetailsRepo issuedBookDetailsRepo;

	@Autowired
	private OverdueFeeRepo overdueFeeRepo;

	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private UserRepo userRepo;

	public String issueBook(Book book, User user) {

		Book issuedBook = this.bookRepo.findById(book.getBookId()).get();

		if (!issuedBook.isAvailable()) {
			return book.getTitle() + " cannot be issued. It's borrowed by some other customer.";
		}

		IssuedBookDetails details = new IssuedBookDetails(book, user, new Date(), null, null);
		this.issuedBookDetailsRepo.save(details);

		// change availability status

		issuedBook.setAvailable(false);
		this.bookRepo.save(issuedBook);
		return book.getTitle() + " issued by user : " + user.getName() + ". You should return the book by "
				+ details.getExpectedReturnDate();

	}

	public List<IssuedBookDetails> getAllIssuedBookDetails() {
		return this.issuedBookDetailsRepo.findAll();
	}

	public String returnBook(int issuedBookId) {

		IssuedBookDetails details = this.issuedBookDetailsRepo.findById(issuedBookId).get();

		Instant expectedReturnDate = details.getExpectedReturnDate().toInstant();
		Instant actualReturnDate = new Date().toInstant();
		long dueDays = Duration.between(expectedReturnDate, actualReturnDate).toDays();

		if (dueDays < 0) {
			this.issuedBookDetailsRepo.delete(details);
		} else {
			details.setReturnDate(new Date());
			OverdueFee fine = new OverdueFee((int) dueDays * 5, false);
			details.setFine(fine);
			this.overdueFeeRepo.save(fine);
			this.issuedBookDetailsRepo.save(details);
		}

		Book updateAvailability = details.getIssuedBook();
		updateAvailability.setAvailable(true);
		this.bookRepo.save(updateAvailability);

		return "The book: " + updateAvailability.getTitle() + " is returned on : " + new Date() + ". Fine: "
				+ ((dueDays < 0) ? "" : (int) dueDays * 5);
	}
	
	public List<IssuedBookDetails> getIssuedBookDetailsByUserId(int userId) {
		return this.issuedBookDetailsRepo.findByBorrower(this.userRepo.findById(userId).get());
	}

}
