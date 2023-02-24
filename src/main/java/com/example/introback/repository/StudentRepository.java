package com.example.introback.repository;

import com.example.introback.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ulan on 2/11/2023
 */

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> searchByName(String name);
    List<Student> searchBySurname(String surname);
    List<Student> searchByGroup(String group);
}
