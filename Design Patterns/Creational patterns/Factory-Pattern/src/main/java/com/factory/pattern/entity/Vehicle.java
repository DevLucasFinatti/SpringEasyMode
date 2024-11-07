package com.factory.pattern.entity;

import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue
    private UUID vehicleId;

    @Enumerated(EnumType.STRING)
    private VehicleBrandEnum brand;

    @Enumerated(EnumType.STRING)
    private VehicleColorEnum color;

    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum type;

    protected Vehicle() {}

    public Vehicle(VehicleBrandEnum brand, VehicleColorEnum color, VehicleTypeEnum type) {
        this.brand = brand;
        this.color = color;
        this.type = type;
    }

    public VehicleTypeEnum getType() {
        return type;
    }

    public void setType(VehicleTypeEnum type) {
        this.type = type;
    }

    public VehicleColorEnum getColor() {
        return color;
    }

    public void setColor(VehicleColorEnum color) {
        this.color = color;
    }

    public VehicleBrandEnum getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrandEnum brand) {
        this.brand = brand;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }
}
