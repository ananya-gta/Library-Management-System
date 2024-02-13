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

	public List<Book> findAll() {
		return this.bookRepo.findAll();
	}

	public List<Book> findByBookId(int bookId) {
		return this.bookRepo.findByBookId(bookId);
	}

	public List<Book> findByGenre(String genre) {
		return this.bookRepo.findByGenre(genre);
	}

	public List<Book> findByAuthor(String author) {
		return this.bookRepo.findByAuthor(author);
	}

}
