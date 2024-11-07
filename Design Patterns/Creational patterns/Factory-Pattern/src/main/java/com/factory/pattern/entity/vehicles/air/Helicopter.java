package com.factory.pattern.entity.vehicles.air;

import com.factory.pattern.entity.Vehicle;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "helicopter")
public class Helicopter extends Vehicle {
    private Integer propellerNum;
    private Integer windowsNum;
    private Integer doorsNum;

    public Helicopter() {
        super();
    }

    public Helicopter(VehicleBrandEnum brand, VehicleColorEnum color, VehicleTypeEnum type,
                      Integer propellerNum, Integer windowsNum, Integer doorsNum) {
        super(brand, color, type);
        this.propellerNum = propellerNum;
        this.windowsNum = windowsNum;
        this.doorsNum = doorsNum;
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
