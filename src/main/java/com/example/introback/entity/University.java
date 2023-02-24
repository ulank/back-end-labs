package com.example.introback.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Ulan on 2/24/2023
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "universites", schema = "university")
@ToString
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

}
