package com.example.introback.service;

import com.example.introback.entity.Student;
import com.example.introback.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ulan on 2/11/2023
 */

@Service
@Slf4j
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> searchBySlug(String type, String slug) {
        if (slug.equals("")) {
            return studentRepository.findAll();
        } else {
            if (type.equals("NAME")) {
                return studentRepository.searchByName(slug);
            }
            if (type.equals("SURNAME")) {
                return studentRepository.searchBySurname(slug);
            }
            if (type.equals("GROUP")) {
                return studentRepository.searchByGroup(slug);
            }
        }
        return new ArrayList<>();
    }


}
