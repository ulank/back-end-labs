package com.example.introback.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Ulan on 2/17/2023
 */

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "cars", schema = "university")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "car_name", nullable = false)
    private String name;

    @Column(name = "car_model", nullable = false)
    private String model;

    @Column(name = "car_year", nullable = false)
    private Integer year;

    @Column(name = "car_volume", nullable = false)
    private Double volume;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return id != null && Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
