package com.example.introback.controller;

import com.example.introback.entity.Car;
import com.example.introback.entity.University;
import com.example.introback.entity.User;
import com.example.introback.service.UniversityService;
import com.example.introback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ulan on 2/24/2023
 */
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UniversityService universityService;

    @GetMapping("/users")
    public String fetchAll(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("newUser", new User());
        model.addAttribute("universites", universityService.findAll());
        return "users";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/newuniversity")
    public String addNewUniversity(Model model) {
        University university = new University();
        model.addAttribute("university", university);
        return "newuniversity";
    }

    @PostMapping("/addUniversity")
    public String addNew(@ModelAttribute("university") University university) {
        universityService.createUniversity(university);
        return "redirect:/users";
    }


}
