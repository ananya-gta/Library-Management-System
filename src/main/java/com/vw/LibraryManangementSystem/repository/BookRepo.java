package com.vw.LibraryManangementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vw.LibraryManangementSystem.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	
	@Query("SELECT b FROM Book b WHERE lower(b.genre) = lower(?1)")
	public List<Book> findByGenreIgnoreCase(String genre);

	@Query("SELECT b FROM Book b WHERE lower(b.title) = lower(?1)")
	public List<Book> findByTitleIgnoreCase(String title);

	@Query("SELECT b FROM Book b WHERE lower(b.author) = lower(?1)")
	public List<Book> findByAuthorIgnoreCase(String author);

//	public List<Book> findByAvailable(String available);

}
