package com.factory.pattern.controller.vehicle.land;

import com.factory.pattern.base.ApiResponse;
import com.factory.pattern.base.SystemMessages;
import com.factory.pattern.entity.dto.vehicle.land.CarDto;
import com.factory.pattern.entity.vehicles.land.Car;
import com.factory.pattern.service.vehicle.land.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public ApiResponse createCar (@RequestBody CarDto carDto){
        try {
            if (carService.validateCarDto(carDto)){
                carService.createCar(carDto);
                return new ApiResponse(carDto, SystemMessages.System.ENTITY_NOT_FOUND);
            }
            return new ApiResponse(carDto, SystemMessages.System.DYNAMIC_ERROR);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

}
