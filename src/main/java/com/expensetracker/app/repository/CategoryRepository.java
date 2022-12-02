package com.expensetracker.app.repository;

import com.expensetracker.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//mapping category bean to database table
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);                //search the table
}
