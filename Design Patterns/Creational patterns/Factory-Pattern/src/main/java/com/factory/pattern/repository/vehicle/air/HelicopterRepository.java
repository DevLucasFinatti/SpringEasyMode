
package com.factory.pattern.repository.vehicle.air;

import com.factory.pattern.entity.User;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.vehicles.air.Helicopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HelicopterRepository extends JpaRepository<Helicopter, UUID> {
    Optional<Helicopter> findByVehicleId(UUID vehicleId);
    List<Helicopter> findByBrand(VehicleBrandEnum brand);
    List<Helicopter> findByPropellerNum(Integer propellerNum);
}
