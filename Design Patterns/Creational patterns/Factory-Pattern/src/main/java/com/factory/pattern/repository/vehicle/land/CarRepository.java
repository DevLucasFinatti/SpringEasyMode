package com.factory.pattern.repository.vehicle.land;

import com.factory.pattern.entity.enums.car.WheelDriveTypeEnum;
import com.factory.pattern.entity.enums.car.WheelsTypeEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.vehicles.land.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByBrand(VehicleBrandEnum brand);
    List<Car> findByWheelsType(WheelsTypeEnum wheelsType);
    List<Car> findByWheelDrive(WheelDriveTypeEnum wheelDrive);
    List<Car> findByDoorsNum(Integer doorsNum);
}
