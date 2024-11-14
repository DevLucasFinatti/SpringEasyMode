package com.factory.pattern.entity.dto.vehicle.water;

import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;

import java.util.UUID;

public class BoatDto {
    private VehicleBrandEnum brand;
    private VehicleColorEnum color;
    private VehicleTypeEnum type;
    private Integer sailsNum;
    private Boolean hasMotor;

    public BoatDto(VehicleBrandEnum brand, VehicleColorEnum color, VehicleTypeEnum type, Integer sailsNum, Boolean hasMotor) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.sailsNum = sailsNum;
        this.hasMotor = hasMotor;
    }

    public BoatDto() {
    }

    public VehicleBrandEnum getBrand() {
        return brand;
    }

    public void setBrand(VehicleBrandEnum brand) {
        this.brand = brand;
    }

    public VehicleColorEnum getColor() {
        return color;
    }

    public void setColor(VehicleColorEnum color) {
        this.color = color;
    }

    public VehicleTypeEnum getType() {
        return type;
    }

    public void setType(VehicleTypeEnum type) {
        this.type = type;
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
