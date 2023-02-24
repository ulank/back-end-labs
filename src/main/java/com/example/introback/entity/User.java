package com.example.introback.entity;

import com.sun.istack.NotNull;
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
@Table(name = "users", schema = "university")
@ToString
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id", referencedColumnName = "id", nullable = true)
    private University university;

}
