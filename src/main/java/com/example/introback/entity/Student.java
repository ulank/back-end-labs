package com.example.introback.entity;

import lombok.*;

import javax.persistence.*;


/**
 * Created by Ulan on 2/11/2023
 */


@Entity
@Getter
@Setter
@Table(name = "students", schema = "university")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_surname")
    private String surname;

    @Column(name = "group_name")
    private String group;

    @Column(name = "admitted_year")
    private int admittedYear;

}
