package com.factory.pattern.service.vehicle.land;

import com.factory.pattern.entity.dto.vehicle.land.CarDto;
import com.factory.pattern.entity.enums.car.WheelDriveTypeEnum;
import com.factory.pattern.entity.enums.car.WheelsTypeEnum;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.vehicles.land.Car;
import com.factory.pattern.repository.vehicle.land.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        car.setWheelDrive(carDto.getWheelDrive());
        car.setDoorsNum(carDto.getDoorsNum());
        return car;
    }

    public Boolean validateCarDto(CarDto carDto) {
        return carDto.getBrand() != null && carDto.getColor() != null && carDto.getType() != null &&
                carDto.getCategoryEnum() != null && carDto.getWheelsType() != null && carDto.getWheelDrive() != null &&
                carDto.getDoorsNum() != null;
    }

    public void createCar(CarDto carDto) {
        Car car = convertDtoToCar(carDto);
        carRepository.save(car);
    }

    public Car getById(String vehicleId) {
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        return carRepository.findById(UUID.fromString(vehicleId)).orElse(null);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public List<CarDto> getByBrand(VehicleBrandEnum brand) {
        List<Car> cars = carRepository.findByBrand(brand);
        return convertCarsToDtos(cars);
    }

    public List<CarDto> getByWheelsType(WheelsTypeEnum wheelsType) {
        List<Car> cars = carRepository.findByWheelsType(wheelsType);
        return convertCarsToDtos(cars);
    }

    public List<CarDto> getByWheelDrive(WheelDriveTypeEnum wheelDrive) {
        List<Car> cars = carRepository.findByWheelDrive(wheelDrive);
        return convertCarsToDtos(cars);
    }

    public List<CarDto> getByDoorsNum(Integer doorsNum) {
        List<Car> cars = carRepository.findByDoorsNum(doorsNum);
        return convertCarsToDtos(cars);
    }

    public void deleteById(String vehicleId) {
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        carRepository.deleteById(UUID.fromString(vehicleId));
    }

    public Car updateById(String vehicleId, CarDto carDto) {
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        Optional<Car> optionalCar = carRepository.findById(UUID.fromString(formattedUuid));
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setType(carDto.getType());
            car.setCategoryEnum(carDto.getCategoryEnum());
            car.setWheelsType(carDto.getWheelsType());
            car.setWheelDrive(carDto.getWheelDrive());
            car.setDoorsNum(carDto.getDoorsNum());
            carRepository.save(car);
            return car;
        }
        return null;
    }

    private CarDto convertCarToDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setBrand(car.getBrand());
        carDto.setColor(car.getColor());
        carDto.setType(car.getType());
        carDto.setCategoryEnum(car.getCategoryEnum());
        carDto.setWheelsType(car.getWheelsType());
        carDto.setWheelDrive(car.getWheelDrive());
        carDto.setDoorsNum(car.getDoorsNum());
        return carDto;
    }

    private List<CarDto> convertCarsToDtos(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(convertCarToDto(car));
        }
        return carDtos;
    }
}