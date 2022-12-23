package com.expensetracker.app.service;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.Expense;
import com.expensetracker.app.parameters.CategoryCreationParameters;
import com.expensetracker.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService {
    //@Autowired
    private final CategoryRepository categoryRepository;

   public CategoryService(CategoryRepository categoryRepository){
       this.categoryRepository = categoryRepository;
   }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Integer id) {
        return categoryRepository.findById(id).get();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category category) {
        categoryRepository.save(category);
    }
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
    public Category createCategory(CategoryCreationParameters parameters) {
        Category category = new Category( parameters.getCategoryName(),
    				parameters.getUser());
    		return categoryRepository.save(category);
    	}
}

