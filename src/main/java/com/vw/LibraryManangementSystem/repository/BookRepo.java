package com.vw.LibraryManangementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.LibraryManangementSystem.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
	public List<Book> findByBookId(int bookId);
	
	public List<Book> findByGenre(String genre);
	
	public List<Book> findByTitle(String title);
	
	public List<Book> findByAuthor(String author);
	
	public List<Book> findByAvailable(String available);
	
}
