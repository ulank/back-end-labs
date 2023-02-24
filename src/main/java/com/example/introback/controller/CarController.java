package com.example.introback.controller;

import com.example.introback.entity.Car;
import com.example.introback.entity.Student;
import com.example.introback.service.CarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * Created by Ulan on 2/17/2023
 */

@Slf4j
@Controller
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public String fetchAll(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "cars";
    }

    @GetMapping("/newcar")
    public String addNewEmployee(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "newcar";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("car") Car car) {
        carService.create(car);
        return "redirect:/cars";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Car car = carService.updateById(id, new Car());
        model.addAttribute("car", car);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }

}
