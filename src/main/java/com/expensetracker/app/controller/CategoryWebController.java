package com.expensetracker.app.controller;


import com.expensetracker.app.model.Category;
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

    	@GetMapping("/template2")
    	public String getAllCategories(Model model) {
    		List<Category> categories = categoryService.getAllCategories();
    		model.addAttribute("categories", categories);
    		return "categoriesTemplate";
    	}

    	@RequestMapping("/{id}")
    	public Category getCategory(@PathVariable Integer categoryId) {
    		return categoryService.getCategory(categoryId);
    	}

    	@RequestMapping("/addCategory")
    	public String addCategory(Category category) {
    		categoryService.addCategory(category);
    		return"addCategory";
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
