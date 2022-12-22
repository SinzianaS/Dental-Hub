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
@RequestMapping("/category")
public class CategoryWebController {

    @Autowired
    private CategoryService categoryService;

    public CategoryWebController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String showCreateCategoryForm(Model model) {
        model.addAttribute("formData", new CreateCategoryFormData());
        return "category-form";
    }

    @PostMapping("/create")
    public String doCreateCategory(@Valid @ModelAttribute("formData") CreateCategoryFormData formData,
                                   BindingResult bindingResult,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            return "category-form";
        }

        categoryService.createCategory(formData.toParameters());

        return "redirect:/category/create";
    }

    @GetMapping("/template2")
    public String listExpenses(Model model) {
        model.addAttribute("expenses", categoryService.getAllCategories());
        return "categoryTemplate";
    }

}
