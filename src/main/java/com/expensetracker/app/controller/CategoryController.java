package com.expensetracker.app.controller;

import com.expensetracker.app.model.Category;
import com.expensetracker.app.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories(){
        return categoryRepository.findAll();        //select all from category table
    }

    @GetMapping("category/{id}")
    ResponseEntity<?> getCategory(@PathVariable int id){
        //Category category =  categoryRepository.findById(id);
        Optional<Category> category =categoryRepository.findById(id);  //Optional because the category might not exist
        return category.map(response -> ResponseEntity.ok().body(response))
                                        .orElse((new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }

    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
        Category result = categoryRepository.save(category);             //insert into table
        return ResponseEntity.created(new URI("/api/category" + result.getCategoryId())).body(result);
    }

    @PutMapping("/category")                       //override/modify a category
    ResponseEntity<Category> updateCategory(@RequestBody @Valid Category category) {
        Category result= categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")                 //delete a category by id
    ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
