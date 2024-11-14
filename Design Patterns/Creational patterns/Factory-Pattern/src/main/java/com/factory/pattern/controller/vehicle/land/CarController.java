package com.factory.pattern.controller.vehicle.land;

import com.factory.pattern.base.ApiResponse;
import com.factory.pattern.base.SystemMessages;
import com.factory.pattern.entity.dto.vehicle.land.CarDto;
import com.factory.pattern.entity.enums.car.WheelDriveTypeEnum;
import com.factory.pattern.entity.enums.car.WheelsTypeEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.vehicles.land.Car;
import com.factory.pattern.service.vehicle.land.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public ApiResponse createCar(@RequestBody CarDto carDto) {
        try {
            if (carService.validateCarDto(carDto)) {
                carService.createCar(carDto);
                return new ApiResponse(carDto, SystemMessages.Car.SUCCESS_CREATED);
            }
            return new ApiResponse(carDto, SystemMessages.Car.MISSING_VALUES);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ApiResponse getById(@PathVariable String id) {
        try {
            Car car = carService.getById(id);
            if (car == null) {
                return new ApiResponse(null, SystemMessages.Car.NOT_FOUND);
            }
            return new ApiResponse(car, SystemMessages.Car.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/all")
    public ApiResponse getAll() {
        try {
            List<Car> cars = carService.getAll();
            if (cars.isEmpty()) {
                return new ApiResponse(cars, SystemMessages.Car.NO_VEHICLE);
            }
            return new ApiResponse(cars, SystemMessages.Car.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/brand/{brand}")
    public ApiResponse getByBrand(@PathVariable VehicleBrandEnum brand) {
        try {
            List<CarDto> cars = carService.getByBrand(brand);
            if (cars.isEmpty()) {
                return new ApiResponse(cars, SystemMessages.Car.NO_VEHICLE);
            }
            return new ApiResponse(cars, SystemMessages.Car.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/wheelsType/{wheelsType}")
    public ApiResponse getByWheelsType(@PathVariable WheelsTypeEnum wheelsType) {
        try {
            List<CarDto> cars = carService.getByWheelsType(wheelsType);
            if (cars.isEmpty()) {
                return new ApiResponse(cars, SystemMessages.Car.NO_VEHICLE);
            }
            return new ApiResponse(cars, SystemMessages.Car.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/wheelDrive/{wheelDrive}")
    public ApiResponse getByWheelDrive(@PathVariable WheelDriveTypeEnum wheelDrive) {
        try {
            List<CarDto> cars = carService.getByWheelDrive(wheelDrive);
            if (cars.isEmpty()) {
                return new ApiResponse(cars, SystemMessages.Car.NO_VEHICLE);
            }
            return new ApiResponse(cars, SystemMessages.Car.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/doorsNum/{doorsNum}")
    public ApiResponse getByDoorsNum(@PathVariable Integer doorsNum) {
        try {
            List<CarDto> cars = carService.getByDoorsNum(doorsNum);
            if (cars.isEmpty()) {
                return new ApiResponse(cars, SystemMessages.Car.NOT_FOUND);
            }
            return new ApiResponse(cars, SystemMessages.Car.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable String id) {
        try {
            carService.deleteById(id);
            return new ApiResponse(null, SystemMessages.Car.SUCCESS_DELETED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateById(@PathVariable String id, @RequestBody CarDto carDto) {
        try {
            Car updatedCar = carService.updateById(id, carDto);
            if (updatedCar == null) {
                return new ApiResponse(null, SystemMessages.Car.NOT_FOUND);
            }
            return new ApiResponse(updatedCar, SystemMessages.Car.SUCCESS_UPDATED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }
}
