package com.factory.pattern.entity.vehicles.water;

import com.factory.pattern.entity.Vehicle;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "boat")
public class Boat extends Vehicle {
    private Integer sailsNum;
    private Boolean hasMotor;

    public Boat(VehicleBrandEnum brand, VehicleColorEnum color, VehicleTypeEnum type, Integer sailsNum, Boolean hasMotor) {
        super(brand, color, type);
        this.sailsNum = sailsNum;
        this.hasMotor = hasMotor;
    }

    public Boat() {
    }

    public Integer getSailsNum() {
        return sailsNum;
    }

    public void setSailsNum(Integer sailsNum) {
        this.sailsNum = sailsNum;
    }

    public Boolean getHasMotor() {
        return hasMotor;
    }

    public void setHasMotor(Boolean hasMotor) {
        this.hasMotor = hasMotor;
    }
}
