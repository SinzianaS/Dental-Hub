package com.expensetracker.app.service;

import com.expensetracker.app.model.Expense;
import com.expensetracker.app.parameters.ExpenseCreationParameters;
import com.expensetracker.app.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	public ExpenseService(ExpenseRepository expenseRepository){
		this.expenseRepository = expenseRepository;
	}
/*
	public List<Expense> getAllExpenses() {
		List<Expense> expenses = new ArrayList<>();
        expenseRepository.findAll()
						 .forEach(expenses::add);
		return expenses;
	}

 */
	public List<Expense> getAllExpenses() {
			return expenseRepository.findAll();
	}

	public Expense getExpense(Long id) {
		return expenseRepository.findById(id).get();
	}

	public void addExpense(Expense expense) {
        expenseRepository.save(expense);
	}

	public void updateExpense(Long id, Expense expense) {
        expenseRepository.save(expense);
	}
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
	public Expense createExpense(ExpenseCreationParameters parameters) {
		Expense expense = new Expense(parameters.getCategory(), parameters.getAmount(),
				parameters.getExpenseDate(), parameters.getDescription());
		return expenseRepository.save(expense);
	}

}
