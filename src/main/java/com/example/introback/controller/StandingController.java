package com.example.introback.controller;

import com.example.introback.dto.MatchDto;
import com.example.introback.entity.Match;
import com.example.introback.entity.Student;
import com.example.introback.entity.User;
import com.example.introback.service.StandingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * Created by Ulan on 2/25/2023
 */
@Controller
@RequiredArgsConstructor
public class StandingController {

    private final StandingService standingService;


    @GetMapping("/standing")
    public String standing(Model model) {
        model.addAttribute("standings", standingService.collectMatches());
        model.addAttribute("teams", standingService.findTeams());
        model.addAttribute("newMatch", new Match());
        return "standing";
    }

    @PostMapping("/addMatch")
    public String addMatch(@ModelAttribute("newMatch") Match math) {
        standingService.createMatch(math);
        return "redirect:/standing";
    }

}
