package com.factory.pattern.entity.dto.vehicle.air;

import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;

public class HelicopterDto {
    private VehicleBrandEnum brand;
    private VehicleColorEnum color;
    private VehicleTypeEnum type;
    private Integer propellerNum;
    private Integer windowsNum;
    private Integer doorsNum;

    public HelicopterDto() {}

    public HelicopterDto(VehicleBrandEnum brand, VehicleColorEnum color, VehicleTypeEnum type, Integer propellerNum, Integer windowsNum, Integer doorsNum) {
        this.brand = brand;
        this.color = color;
        this.type = type;
        this.propellerNum = propellerNum;
        this.windowsNum = windowsNum;
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

    public Integer getDoorsNum() {
        return doorsNum;
    }

    public void setDoorsNum(Integer doorsNum) {
        this.doorsNum = doorsNum;
    }
}
