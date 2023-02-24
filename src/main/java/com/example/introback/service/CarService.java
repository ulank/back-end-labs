package com.example.introback.service;

import com.example.introback.entity.Car;
import com.example.introback.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ulan on 2/17/2023
 */
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car create(Car newCar) {
        return carRepository.save(newCar);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car updateById(Long oldCarId, Car newCar) {
        var oldCar = carRepository.findById(oldCarId).orElseThrow();
        oldCar.setName(newCar.getName());
        oldCar.setModel(newCar.getModel());
        oldCar.setYear(newCar.getYear());
        oldCar.setVolume(newCar.getVolume());
        return carRepository.saveAndFlush(oldCar);
    }

    public boolean deleteById(Long carId) {
        assert carId != null;
        carRepository.deleteById(carId);
        return carRepository.existsById(carId);
    }

}
