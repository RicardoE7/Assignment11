package com.codercampus.Assignment11.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepo;

	public Transaction findById(Integer transactionId) {
		return transactionRepo.findByid(transactionId);

	}
	public List<Transaction> findAll() {
		List<Transaction> transactions = transactionRepo.findAll();
		transactions.sort(Comparator.comparing(Transaction::getDate));
		return transactions;
	}
}
