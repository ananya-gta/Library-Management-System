package com.vw.LibraryManangementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.LibraryManangementSystem.entity.OverdueFee;

@Repository
public interface OverdueFeeRepo extends JpaRepository<OverdueFee, Integer>{

}
