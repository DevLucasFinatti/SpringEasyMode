package com.factory.pattern.repository.vehicle.water;

import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.vehicles.land.Car;
import com.factory.pattern.entity.vehicles.water.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BoatRepository extends JpaRepository<Boat, UUID> {
    List<Boat> findAllByHasMotor(Boolean hasMotor);
    List<Boat> findAllBySailsNum(Integer sailNum);
}
