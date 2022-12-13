package com.expensetracker.app.service;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.model.Expense;
import com.expensetracker.app.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll()
                          .forEach(categories::add);
        return categories;
    }

    public Category getCategory(int id) {
        return categoryRepository.findById(id).get();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(int id, Category category) {
        categoryRepository.save(category);
    }
    public void deleteExpense(int id) {
        categoryRepository.deleteById(id);
    }
}
