package com.expensetracker.app.service;

import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	public List<Expense> getAllExpenses() {
		List<Expense> expenses = new ArrayList<>();
        expenseRepository.findAll()
						 .forEach(expenses::add);
		return expenses;
	}

	public Expense getExpense(Long id) {
		return expenseRepository.findById(id).get();
	}

	public void addExpense(Expense expense) {
        expenseRepository.save(expense);
	}
	/*
	public Expense saveExpenseDetails(Expense expense){
		// map object to entity


		//save the entity to database


		//map entity to object

	}

	 */


	public void updateExpense(Long id, Expense expense) {
        expenseRepository.save(expense);
	}
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
