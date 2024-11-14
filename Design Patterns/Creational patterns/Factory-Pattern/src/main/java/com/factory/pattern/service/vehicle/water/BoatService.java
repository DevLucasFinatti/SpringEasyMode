package com.factory.pattern.service.vehicle.water;

import com.factory.pattern.entity.Vehicle;
import com.factory.pattern.entity.dto.vehicle.land.CarDto;
import com.factory.pattern.entity.dto.vehicle.water.BoatDto;
import com.factory.pattern.entity.vehicles.land.Car;
import com.factory.pattern.entity.vehicles.water.Boat;
import com.factory.pattern.repository.vehicle.water.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BoatService {

    @Autowired
    BoatRepository boatRepository;

    public Boat convertToBoat(BoatDto boatDto){
        Boat boat = new Boat();

        boat.setBrand(boatDto.getBrand());
        boat.setColor(boatDto.getColor());
        boat.setType(boatDto.getType());
        boat.setSailsNum(boatDto.getSailsNum());
        boat.setHasMotor(boatDto.getHasMotor());

        return boat;
    }

    public BoatDto convertToBoatDto(Boat boat){
        BoatDto boatDto = new BoatDto();

        boatDto.setBrand(boat.getBrand());
        boatDto.setColor(boat.getColor());
        boatDto.setType(boat.getType());
        boatDto.setSailsNum(boat.getSailsNum());
        boatDto.setHasMotor(boat.getHasMotor());

        return boatDto;
    }

    public List<Boat> getAll() {
        return boatRepository.findAll();
    }

    public void createBoat (BoatDto boatDto) {
        Boat boat = convertToBoat(boatDto);
        boatRepository.save(boat);
    }

    public Vehicle getById(String vehicleId) {
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        return boatRepository.findById(UUID.fromString(vehicleId)).orElse(null);
    }

    public List<BoatDto> getAllByHasMotor(Boolean motor) {
        List<Boat> boatList = boatRepository.findAllByHasMotor(motor);
        List<BoatDto> boatDtoList = new ArrayList<>();

        for (Boat boat: boatList) {
            boatDtoList.add(convertToBoatDto(boat));
        }

        return boatDtoList;
    }

    public List<BoatDto> getAllBySailsNum(Integer sailsNum) {
        List<Boat> boatList = boatRepository.findAllBySailsNum(sailsNum);
        List<BoatDto> boatDtoList = new ArrayList<>();

        for (Boat boat: boatList) {
            boatDtoList.add(convertToBoatDto(boat));
        }

        return boatDtoList;
    }

    public void deleteById(String vehicleId){
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        boatRepository.deleteById(UUID.fromString(vehicleId));
    }

    public Boat updateById(String vehicleId, BoatDto boatDto) {
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );

        Optional<Boat> existingBoat = boatRepository.findById(UUID.fromString(formattedUuid));

        if (existingBoat.isPresent()) {
            Boat boatToUpdate = existingBoat.get();
            boatToUpdate.setBrand(boatDto.getBrand());
            boatToUpdate.setColor(boatDto.getColor());
            boatToUpdate.setType(boatDto.getType());
            boatToUpdate.setSailsNum(boatDto.getSailsNum());
            boatToUpdate.setHasMotor(boatDto.getHasMotor());
            boatRepository.save(boatToUpdate);
            return boatToUpdate;
        } else {
            return null;
        }
    }
}
