package com.factory.pattern.service.vehicle.land;

import com.factory.pattern.entity.dto.vehicle.land.CarDto;
import com.factory.pattern.entity.vehicles.land.Car;
import com.factory.pattern.repository.vehicle.land.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car convertDtoToCar(CarDto carDto) {
        Car car = new Car();

        car.setBrand(carDto.getBrand());
        car.setColor(carDto.getColor());
        car.setType(carDto.getType());
        car.setCategoryEnum(carDto.getCategoryEnum());
        car.setWheelsType(carDto.getWheelsType());
        car.setWhellDrive(carDto.getWhellDrive());
        car.setDoorsNum(carDto.getDoorsNum());

        return car;
    }

    public Boolean validateCarDto(CarDto carDto) {
        if (
                carDto.getBrand() == null ||
                carDto.getColor() == null ||
                carDto.getType() == null ||
                carDto.getCategoryEnum() == null ||
                carDto.getWheelsType() == null ||
                carDto.getWhellDrive() == null ||
                carDto.getDoorsNum() == null
        ) {
            return false;
        }
        return true;
    }

    public void createCar(@RequestBody CarDto carDto){
        Car car = convertDtoToCar(carDto);
        carRepository.save(car);
    }

}
