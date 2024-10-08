package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	private TransactionService transactionService = new TransactionService();

	@GetMapping("/transactions")
	public String getTransactions(ModelMap model) {
		// This is what gets returned when we
		// return a String inside of a regular Controller GetMapping method
		// /src/main/resources/templates/{filename}.html
		List<Transaction> transactions = transactionService.findAll();

		model.put("transactions", transactions);
		return "transactions";
	}

	@GetMapping("/transactions/{transactionId}")
	public String getTransaction(@PathVariable Integer transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);

		model.put("transaction", transaction);
		return "transactions";
	}

}
