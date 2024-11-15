package com.factory.pattern.entity.vehicles.land;

import com.factory.pattern.entity.Vehicle;
import com.factory.pattern.entity.enums.car.CarCategoryEnum;
import com.factory.pattern.entity.enums.car.WheelDriveTypeEnum;
import com.factory.pattern.entity.enums.car.WheelsTypeEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends Vehicle {
    private Integer doorsNum;

    @Enumerated(EnumType.STRING)
    private CarCategoryEnum categoryEnum;

    @Enumerated(EnumType.STRING)
    private WheelDriveTypeEnum wheelDrive;

    @Enumerated(EnumType.STRING)
    private WheelsTypeEnum wheelsType;

    public Car(
            VehicleBrandEnum brand,
            VehicleColorEnum color,
            VehicleTypeEnum type,
            Integer doorsNum,
            CarCategoryEnum categoryEnum,
            WheelDriveTypeEnum wheelDrive,
            WheelsTypeEnum wheelsType
    ) {
        super(brand, color, type);
        this.doorsNum = doorsNum;
        this.categoryEnum = categoryEnum;
        this.wheelDrive = wheelDrive;
        this.wheelsType = wheelsType;
    }

    public Car() {
        super();
    }

    public Integer getDoorsNum() {
        return doorsNum;
    }

    public void setDoorsNum(Integer doorsNum) {
        this.doorsNum = doorsNum;
    }

    public CarCategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CarCategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public WheelDriveTypeEnum getWheelDrive() {
        return wheelDrive;
    }

    public void setWheelDrive(WheelDriveTypeEnum wheelDrive) {
        this.wheelDrive = wheelDrive;
    }

    public WheelsTypeEnum getWheelsType() {
        return wheelsType;
    }

    public void setWheelsType(WheelsTypeEnum wheelsType) {
        this.wheelsType = wheelsType;
    }
}
