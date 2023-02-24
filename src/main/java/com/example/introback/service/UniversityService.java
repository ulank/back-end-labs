package com.example.introback.service;

import com.example.introback.entity.University;
import com.example.introback.repository.UniversityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ulan on 2/24/2023
 */
@Service
@AllArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public void createUniversity(University university) {
        universityRepository.save(university);
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

}
