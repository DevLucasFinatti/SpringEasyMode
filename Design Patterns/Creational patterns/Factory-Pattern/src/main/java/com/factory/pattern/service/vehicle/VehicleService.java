package com.factory.pattern.service.vehicle;

import com.factory.pattern.entity.Vehicle;
import com.factory.pattern.entity.dto.vehicle.VehicleDto;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public VehicleDto VehicleToVehicleDto(Vehicle vehicleDto){
        VehicleDto response = null;

        response.setBrand(vehicleDto.getBrand());
        response.setType(vehicleDto.getType());
        response.setColor(vehicleDto.getColor());

        return response;
    }

    public Vehicle VehicleDtoToVehicle(VehicleDto vehicle){
        Vehicle response = null;

        response.setBrand(vehicle.getBrand());
        response.setType(vehicle.getType());
        response.setColor(vehicle.getColor());

        return response;
    }

    public boolean validateVehicleDto(VehicleDto vehicleDto) {
        return !(vehicleDto.getBrand() == null || vehicleDto.getColor() == null || vehicleDto.getType() == null);
    }
}