package com.vw.LibraryManangementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.LibraryManangementSystem.entity.IssuedBookDetails;

@Repository
public interface IssuedBookDetailsRepo extends JpaRepository<IssuedBookDetails, Integer>{

}
