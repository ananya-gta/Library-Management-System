package com.vw.LibraryManangementSystem.entity;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Entity
public class IssuedBookDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Book issuedBook;
	
	@ManyToOne
	private User borrower;
	private Date issuedDate;
	private Date returnDate;
	private Date expectedReturnDate;
	
	@OneToOne
	private OverdueFee fine;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getIssuedBook() {
		return issuedBook;
	}

	public void setIssuedBook(Book issuedBook) {
		this.issuedBook = issuedBook;
	}

	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public OverdueFee getFine() {
		return fine;
	}

	public void setFine(OverdueFee fine) {
		this.fine = fine;
	}

	public IssuedBookDetails(Book issuedBook, User borrower, Date issuedDate, Date returnDate,
			OverdueFee fine) {
		super();
		this.issuedBook = issuedBook;
		this.borrower = borrower;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.fine = fine;
		this.expectedReturnDate = new Date(issuedDate.getTime() + (14 * 24 * 60 * 60 * 1000));
	}

	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public IssuedBookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IssuedBookDetails [id=" + id + ", issuedBook=" + issuedBook + ", borrower=" + borrower + ", issuedDate="
				+ issuedDate + ", returnDate=" + returnDate + ", fine=" + fine + "]";
	}
	
	
	
}
