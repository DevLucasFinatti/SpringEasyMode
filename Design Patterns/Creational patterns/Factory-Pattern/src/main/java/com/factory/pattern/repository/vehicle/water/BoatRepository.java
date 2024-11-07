package com.factory.pattern.repository.vehicle.water;

import com.factory.pattern.entity.vehicles.water.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoatRepository extends JpaRepository<Boat, UUID> {
}
