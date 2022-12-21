package com.expensetracker.app.controller;

import com.expensetracker.app.form.CreateExpenseFormData;
import com.expensetracker.app.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/web")
public class ExpenseWebController {
	/*
    @Autowired
    private ExpenseService expenseService;

	@GetMapping("/template1")
	public String getAllExpenses(Model model) {
		model.addAttribute("expenses", expenseService.getAllExpenses());
		return "expenseTemplate";
	}

/* ///////
	@RequestMapping("/createExpense")
	public String createExpense(Model model){
		model.addAttribute("expense", new Expense());
		return "expense-form";
	}
*///////////

/*
	@RequestMapping("/createExpense")
	public String createExpense(Expense expense) {
		return"expense-form";
	}

	@RequestMapping(method=RequestMethod.POST, value="/saveOrUpdateExpense")
	public String saveOrUpdateExpense(@ModelAttribute("expense") Expense expense){
		System.out.println("print the expense object"+ expense);
		expenseService.addExpense(expense);
		return "redirect:/web/template1";
	}

 */

	private ExpenseService expenseService;

	public void ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/create")
	public String showCreateExpenseForm(Model model) {
		model.addAttribute("formData", new CreateExpenseFormData());
		return "expense-form";
	}

	@PostMapping("/create")
	public String doCreateExpense(@Valid @ModelAttribute("formData") CreateExpenseFormData formData,
							   BindingResult bindingResult,
							   Model model) {
		if (bindingResult.hasErrors()) {
			return "expense-form";
		}

		expenseService.createExpense(formData.toParameters());

		return "redirect:/template1";
	}

	@GetMapping
	public String listExpenses(Model model) {
		model.addAttribute("expenses", expenseService.getAllExpenses());

		return "expense-form";
	}


}
