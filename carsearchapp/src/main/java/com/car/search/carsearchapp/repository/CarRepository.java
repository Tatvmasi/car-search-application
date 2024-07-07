package com.car.search.carsearchapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.car.search.carsearchapp.entity.Car;

/**
 * Repository interface for accessing Car entities from the database.
 */
public interface CarRepository extends JpaRepository<Car, Long> {

	/**
     * Custom query to search for cars based on specified criteria.
     * @param length Exact length of the car (nullable)
     * @param minLength Minimum length of the car (nullable)
     * @param maxLength Maximum length of the car (nullable)
     * @param weight Exact weight of the car (nullable)
     * @param minWeight Minimum weight of the car (nullable)
     * @param maxWeight Maximum weight of the car (nullable)
     * @param velocity Exact velocity of the car (nullable)
     * @param minVelocity Minimum velocity of the car (nullable)
     * @param maxVelocity Maximum velocity of the car (nullable)
     * @param color Exact color of the car (nullable)
     * @return List of cars matching the specified criteria
     */
	
	@Query("SELECT c FROM Car c " +
	           "WHERE (:length IS NULL OR c.length = :length) " +
	           "AND (:minLength IS NULL OR c.length >= :minLength) " +
	           "AND (:maxLength IS NULL OR c.length <= :maxLength) " +
	           "AND (:weight IS NULL OR c.weight = :weight) " +
	           "AND (:minWeight IS NULL OR c.weight >= :minWeight) " +
	           "AND (:maxWeight IS NULL OR c.weight <= :maxWeight) " +
	           "AND (:velocity IS NULL OR c.velocity = :velocity) " +
	           "AND (:minVelocity IS NULL OR c.velocity >= :minVelocity) " +
	           "AND (:maxVelocity IS NULL OR c.velocity <= :maxVelocity) " +
	           "AND (:color IS NULL OR c.color = :color)")
	    List<Car> findCars(@Param("length") Double length,
	                       @Param("minLength") Double minLength,
	                       @Param("maxLength") Double maxLength,
	                       @Param("weight") Double weight,
	                       @Param("minWeight") Double minWeight,
	                       @Param("maxWeight") Double maxWeight,
	                       @Param("velocity") Double velocity,
	                       @Param("minVelocity") Double minVelocity,
	                       @Param("maxVelocity") Double maxVelocity,
	                       @Param("color") String color);
	
}
