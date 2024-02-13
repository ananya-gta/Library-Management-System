package com.vw.LibraryManangementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vw.LibraryManangementSystem.entity.Book;
import com.vw.LibraryManangementSystem.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bookRepo;

	public List<Book> getAllBooks() {
		return this.bookRepo.findAll();
	}

	public String addBooks(Book book) {
		this.bookRepo.save(book);
		return "Book added successfully";
	}

	public String removeBook(int bookId) {
		this.bookRepo.deleteById(bookId);
		return "Book removed successfully";
	}

	public Book getByBookId(int bookId) {
		return this.bookRepo.findById(bookId).get();
	}

	public List<Book> getByGenre(String genre) {
		return this.bookRepo.findByGenreIgnoreCase(genre);
	}

	public List<Book> getByAuthor(String author) {
		return this.bookRepo.findByAuthorIgnoreCase(author);
	}

	public List<Book> getByTitle(String title) {
		return this.bookRepo.findByTitleIgnoreCase(title);
	}

	public String updateBook(Book book) {
		Book oldBookDetails = this.bookRepo.findById(book.getBookId()).get();
		oldBookDetails.setAuthor(book.getAuthor());
		oldBookDetails.setGenre(book.getGenre());
		oldBookDetails.setTitle(book.getTitle());
		this.bookRepo.save(oldBookDetails);
		return "Book updated";
	}

}
