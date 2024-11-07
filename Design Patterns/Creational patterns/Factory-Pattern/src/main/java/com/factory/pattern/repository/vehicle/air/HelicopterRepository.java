
package com.factory.pattern.repository.vehicle.air;

import com.factory.pattern.entity.vehicles.air.Helicopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HelicopterRepository extends JpaRepository<Helicopter, UUID> {

}
