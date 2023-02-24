package com.example.introback.controller;

import com.example.introback.entity.Student;
import com.example.introback.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by Ulan on 2/11/2023
 */

@Slf4j
@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", new ArrayList<Student>());
        return "students";
    }

    @RequestMapping(path = {"/search"})
    public String search(Model model, String slug, String type)
    {
        model.addAttribute("students", studentService.searchBySlug(type, slug));
        return "students";
    }

}
