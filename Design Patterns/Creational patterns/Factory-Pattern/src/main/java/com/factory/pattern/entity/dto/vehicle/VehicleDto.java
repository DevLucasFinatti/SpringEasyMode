package com.factory.pattern.entity.dto.vehicle;

import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;

public class VehicleDto {
    private VehicleBrandEnum brand;
    private VehicleColorEnum color;
    private VehicleTypeEnum type;

    public VehicleDto() {
    }

    public VehicleDto(VehicleBrandEnum brand, VehicleColorEnum color, VehicleTypeEnum type) {
        this.brand = brand;
        this.color = color;
        this.type = type;
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
}
