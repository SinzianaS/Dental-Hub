package com.expensetracker.app.controller;

import com.expensetracker.app.model.Expense;
import com.expensetracker.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web")
public class ExpenseWebController {
    @Autowired
    private ExpenseService expenseService;

	@GetMapping("/template1")
	public String getAllExpenses(Model model) {
		model.addAttribute("expenses", expenseService.getAllExpenses());
		return "expenseTemplate";
	}

/*
	@RequestMapping("/createExpense")
	public String createExpense(Model model){
		model.addAttribute("expense", new Expense());
		return "expense-form";
	}
*/


	@RequestMapping("/createExpense")
	public String createExpense(Expense expense) {
		expenseService.addExpense(expense);
		return"expense-form";
	}

	@RequestMapping(method=RequestMethod.POST, value="/saveOrUpdateExpense")
	public String saveOrUpdateExpense(@ModelAttribute("expense") Expense expense){
		System.out.println("print the expense object"+ expense);
		return "redirect:/web/template1";
	}

}
