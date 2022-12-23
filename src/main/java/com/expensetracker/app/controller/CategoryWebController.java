package com.expensetracker.app.controller;

import com.expensetracker.app.form.CreateCategoryFormData;
import com.expensetracker.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryWebController {

    //@Autowired
    private final CategoryService categoryService;

    public CategoryWebController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String showCreateCategoryForm(Model model) {
        model.addAttribute("categoryData", new CreateCategoryFormData());
        return "category-form";
    }

    @PostMapping("/create")
    public String doCreateCategory(@Valid @ModelAttribute("categoryData") CreateCategoryFormData categoryData,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            return "category-form";
        }

        categoryService.createCategory(categoryData.toParameters());

        return "redirect:/categories/create";
    }

    @GetMapping
    public String listExpenses(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categoryTemplate";
    }

}
