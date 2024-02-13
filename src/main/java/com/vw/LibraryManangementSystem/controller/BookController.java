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
import com.vw.LibraryManangementSystem.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/get")
	public List<Book> getAllBooks() {
		return this.bookService.getAllBooks();
	}

	@PostMapping("/add")
	public String addBooks(@RequestBody Book book) {
		return this.bookService.addBooks(book);
	}

	@GetMapping("/getByGenre/{genre}")
	public List<Book> getBookByGenre(@PathVariable String genre) {
		return this.bookService.getByGenre(genre);
	}

	@GetMapping("/getByAuthor/{author}")
	public List<Book> getBookByAuthor(@PathVariable String author) {
		return this.bookService.getByAuthor(author);
	}

	@GetMapping("/getByTitle/{title}")
	public List<Book> getBookByTitle(@PathVariable String title) {
		return this.bookService.getByTitle(title);
	}

	@GetMapping("/getByBookId/{bookId}")
	public List<Book> getBookById(@PathVariable int bookId) {
		return this.bookService.getByBookId(bookId);
	}

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> removeBookById(@PathVariable int bookId) {
		return new ResponseEntity<>(this.bookService.removeBook(bookId), HttpStatus.OK);
	}

}
