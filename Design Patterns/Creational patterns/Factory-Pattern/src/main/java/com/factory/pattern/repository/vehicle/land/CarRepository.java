package com.factory.pattern.repository.vehicle.land;

import com.factory.pattern.entity.vehicles.land.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {

}
