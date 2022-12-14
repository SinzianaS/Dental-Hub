package com.expensetracker.app.controller;

import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.ExpenseRepository;
import com.expensetracker.app.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private ExpenseService expenseService;

    @RequestMapping("/expenses")         //get all expenses
    List<Expense> getExpenses() {
        //return expenseRepository.findAll();
        return expenseService.getAllExpenses();
    }

    @RequestMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpense(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/expenses")
        public void addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/expenses/{id}")
    public void updateExpense(@RequestBody Expense expense, @PathVariable Long id) {
        expenseService.updateExpense(id, expense);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/expenses/{id}")
    public void deleteTopic(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }
}
