package com.expensetracker.app.controller;

import com.expensetracker.app.model.Expense;
import com.expensetracker.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/web")
public class ExpenseWebController {
    @Autowired
    private ExpenseService expenseService;

	@GetMapping("/template1")
	public String getAllExpenses(Model model) {
		List<Expense> expenses = expenseService.getAllExpenses();
		model.addAttribute("expense", expenses);
		return "expenseTemplate";
	}

	@RequestMapping("/expense/{id}")
	public Expense getExpense(@PathVariable Long id) {
		return expenseService.getExpense(id);
	}

	@RequestMapping("/addExpense")
	public String addExpense(Expense expense) {
		expenseService.addExpense(expense);
		return"addExpense";
	}

	@RequestMapping(method=RequestMethod.PUT, value="/expenses/{id}")
	public void updateExpense(@RequestBody Expense expense, @PathVariable Long id) {
		expenseService.updateExpense(id, expense);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/expenses/{id}")
	public void deleteExpense(@PathVariable Long id) {
		expenseService.deleteExpense(id);
	}




}
