package com.expensetracker.app.controller;


import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.ExpenseRepository;
import com.expensetracker.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryWebController {
    @Autowired
    private CategoryService categoryService;
	@Autowired
	private ExpenseRepository expenseRepository;

	@GetMapping("/template2")
	public String getAllCategories(Model model) {
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories", categories);
		return "categoryTemplate";
	}

	@RequestMapping("/{id}")
	public Category getCategory(@PathVariable Integer categoryId) {
		return categoryService.getCategory(categoryId);
	}
	@RequestMapping("/createCategory")
	public String createCategory(Category category) {
		return"category-form";
	}
/*
	@RequestMapping(method= RequestMethod.POST, value="/addCategory")
	public String addCategory(Category category) {
		categoryService.addCategory(category);
		return"category-form";
	}

 */
	@RequestMapping(method=RequestMethod.POST, value="/saveOrUpdateCategory")
	public String saveOrUpdateCategory(@ModelAttribute("category") Category category){
		System.out.println("print the category object "+ category);
		categoryService.addCategory(category);
		return "redirect:/category/template2";
	}

	@RequestMapping(method= RequestMethod.PUT, value="/{id}")
	public void updateCategory(@RequestBody Category category, @PathVariable Integer id) {
		categoryService.updateCategory(id, category);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
	}

}
