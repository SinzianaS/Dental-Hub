package com.expensetracker.app.controller;

import com.expensetracker.app.form.CreateExpenseFormData;
import com.expensetracker.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseWebController {

    private final ExpenseService expenseService;

    public ExpenseWebController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/create")
    public String showCreateExpenseForm(Model model) {
        model.addAttribute("expenseData", new CreateExpenseFormData());
        return "expense-form";
    }

    @PostMapping("/create")
    public String doCreateExpense(@Valid @ModelAttribute("expenseData") CreateExpenseFormData expenseData,
                                  BindingResult bindingResult,
                                  Model model) {
        if (bindingResult.hasErrors()) {
            return "expense-form";
        }

        expenseService.createExpense(expenseData.toParameters());
        System.out.println("expense object:" +expenseData);

        return "redirect:/expenses";
    }

    @GetMapping
    public String listExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenseTemplate";
    }


}
