package com.vw.LibraryManangementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.LibraryManangementSystem.entity.IssuedBookDetails;
import com.vw.LibraryManangementSystem.entity.User;

@Repository
public interface IssuedBookDetailsRepo extends JpaRepository<IssuedBookDetails, Integer>{
	
	public List<IssuedBookDetails> findByBorrower(User user);
}
