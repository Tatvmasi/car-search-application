package com.car.search.carsearchapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.search.carsearchapp.entity.Car;
import com.car.search.carsearchapp.repository.CarRepository;


/**
 * Service class for business logic related to Car entities.
 */
@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public List<Car> searchCars(Double length, Double minLength, Double maxLength, Double weight, Double minWeight,
			Double maxWeight, Double velocity, Double minVelocity, Double maxVelocity, String color) {

		if ("".equals(color)) {
			color = null;
		}

		return carRepository.findCars(length, minLength, maxLength, weight, minWeight, maxWeight, velocity, minVelocity,
				maxVelocity, color);
	}

	public List<Car> getCarsByIds(List<Long> carIds) {
		return carRepository.findAllById(carIds);
	}

	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
}
