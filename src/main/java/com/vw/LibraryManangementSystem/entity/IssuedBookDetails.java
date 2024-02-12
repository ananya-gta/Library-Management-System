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
@Data
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
	
	@OneToOne
	private OverdueFee fine;
}
