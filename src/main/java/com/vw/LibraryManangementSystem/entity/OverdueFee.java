package com.vw.LibraryManangementSystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class OverdueFee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transactionId;
	private int fineAmount;
	private boolean isPaid;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public OverdueFee(int fineAmount, boolean isPaid) {
		super();
		this.fineAmount = fineAmount;
		this.isPaid = isPaid;
	}
	public OverdueFee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OverdueFee [transactionId=" + transactionId + ", fineAmount=" + fineAmount + ", isPaid=" + isPaid + "]";
	}
	
	
}
