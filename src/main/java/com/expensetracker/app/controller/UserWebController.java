package com.expensetracker.app.controller;

import com.expensetracker.app.form.CreateUserFormData;
import com.expensetracker.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserWebController {
    private final UserService userService;

    public UserWebController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/create")
       public String showCreateUserForm(Model model) {
           model.addAttribute("userData", new CreateUserFormData());
           return "user-form";
       }

       @PostMapping("/create")
       public String doCreateUser(@Valid @ModelAttribute("userData") CreateUserFormData userData,
                                  BindingResult bindingResult,
                                  Model model) {
           if (bindingResult.hasErrors()) {
               return "user-form";
           }

           userService.createUser(userData.toParameters());

           return "redirect:/users/create";
       }

       @GetMapping
       public String listUsers(Model model) {
           model.addAttribute("users", userService.getAllUsers());
           return "userTemplate";
       }
}
