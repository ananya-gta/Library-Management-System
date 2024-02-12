package com.vw.LibraryManangementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.LibraryManangementSystem.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
	
	
}
