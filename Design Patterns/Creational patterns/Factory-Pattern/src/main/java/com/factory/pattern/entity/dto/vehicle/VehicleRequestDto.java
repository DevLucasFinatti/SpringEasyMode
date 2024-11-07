package com.factory.pattern.entity.dto.vehicle;

import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;
import com.factory.pattern.entity.enums.car.CarCategoryEnum;
import com.factory.pattern.entity.enums.car.WheelDriveTypeEnum;
import com.factory.pattern.entity.enums.car.WheelsTypeEnum;

// Outros imports...

public class VehicleRequestDto {
    private VehicleBrandEnum brand;
    private VehicleColorEnum color;
    private VehicleTypeEnum type;

    // Parâmetros adicionais para Car
    private Integer doorsNum;
    private CarCategoryEnum categoryEnum;
    private WheelDriveTypeEnum whellDrive;
    private WheelsTypeEnum wheelsType;

    // Parâmetros adicionais para Helicopter
    private Integer propellerNum;
    private Integer windowsNum;
    private Integer propellerBladesNum;

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

    public Integer getPropellerNum() {
        return propellerNum;
    }

    public void setPropellerNum(Integer propellerNum) {
        this.propellerNum = propellerNum;
    }

    public Integer getWindowsNum() {
        return windowsNum;
    }

    public void setWindowsNum(Integer windowsNum) {
        this.windowsNum = windowsNum;
    }

    public Integer getPropellerBladesNum() {
        return propellerBladesNum;
    }

    public void setPropellerBladesNum(Integer propellerBladesNum) {
        this.propellerBladesNum = propellerBladesNum;
    }
}
