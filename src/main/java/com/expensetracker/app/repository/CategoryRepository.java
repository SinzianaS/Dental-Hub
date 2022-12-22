package com.expensetracker.app.repository;

import com.expensetracker.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//mapping category bean to database table
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findByName(String name);                //search the table
}
