package com.factory.pattern.entity.dto.vehicle.land;

import com.factory.pattern.entity.enums.car.CarCategoryEnum;
import com.factory.pattern.entity.enums.car.WheelDriveTypeEnum;
import com.factory.pattern.entity.enums.car.WheelsTypeEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;

public class CarDto {
    private VehicleBrandEnum brand;
    private VehicleColorEnum color;
    private VehicleTypeEnum type;
    private CarCategoryEnum categoryEnum;
    private WheelDriveTypeEnum whellDrive;
    private WheelsTypeEnum wheelsType;
    private Integer doorsNum;

    public CarDto() {
    }

    public CarDto(
            VehicleBrandEnum brand,
            VehicleColorEnum color,
            VehicleTypeEnum type,
            CarCategoryEnum categoryEnum,
            WheelDriveTypeEnum whellDrive,
            WheelsTypeEnum wheelsType,
            Integer doorsNum
    ) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.categoryEnum = categoryEnum;
        this.whellDrive = whellDrive;
        this.wheelsType = wheelsType;
        this.doorsNum = doorsNum;
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

    public CarCategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CarCategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public WheelDriveTypeEnum getWhellDrive() {
        return whellDrive;
    }

    public void setWhellDrive(WheelDriveTypeEnum whellDrive) {
        this.whellDrive = whellDrive;
    }

    public WheelsTypeEnum getWheelsType() {
        return wheelsType;
    }

    public void setWheelsType(WheelsTypeEnum wheelsType) {
        this.wheelsType = wheelsType;
    }

    public Integer getDoorsNum() {
        return doorsNum;
    }

    public void setDoorsNum(Integer doorsNum) {
        this.doorsNum = doorsNum;
    }
}
