package com.expensetracker.app.repository;

import com.expensetracker.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//mapping category bean to database table
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByCategoryName(String name);                //search the table
}
