package com.factory.pattern.factory;

import com.factory.pattern.entity.Vehicle;
import com.factory.pattern.entity.enums.car.CarCategoryEnum;
import com.factory.pattern.entity.enums.car.WheelDriveTypeEnum;
import com.factory.pattern.entity.enums.car.WheelsTypeEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleColorEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleTypeEnum;
import com.factory.pattern.entity.vehicles.air.Helicopter;
import com.factory.pattern.entity.vehicles.land.Car;
import com.factory.pattern.entity.vehicles.water.Boat;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleTypeEnum type, VehicleBrandEnum brand, VehicleColorEnum color, Object... additionalParams) {
        switch (type) {
            case CAR:
                return new Car(
                        brand, color, type,
                        (Integer) additionalParams[0],
                        (CarCategoryEnum) additionalParams[1],
                        (WheelDriveTypeEnum) additionalParams[2],
                        (WheelsTypeEnum) additionalParams[3]);
            case BOAT:
                return new Boat(brand, color, type,
                        (Integer) additionalParams[0],
                        (Boolean) additionalParams[1]);
            case HELICOPTER:
                return new Helicopter(brand, color, type,
                        (Integer) additionalParams[0],
                        (Integer) additionalParams[1],
                        (Integer) additionalParams[2]);
            default:
                throw new IllegalArgumentException("Tipo de veículo não suportado");
        }
    }
}
