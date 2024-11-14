package com.factory.pattern.service.vehicle.air;

import com.factory.pattern.entity.dto.vehicle.air.HelicopterDto;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.vehicles.air.Helicopter;
import com.factory.pattern.repository.vehicle.air.HelicopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HelicopterService {

    @Autowired
    private HelicopterRepository helicopterRepository;

    public HelicopterDto helicopterConvertToDto (Helicopter helicopter){
        var helicopterDto = new HelicopterDto();

        helicopterDto.setType(helicopter.getType());
        helicopterDto.setColor(helicopter.getColor());
        helicopterDto.setBrand(helicopter.getBrand());
        helicopterDto.setWindowsNum(helicopter.getWindowsNum());
        helicopterDto.setDoorsNum(helicopter.getDoorsNum());
        helicopterDto.setPropellerNum(helicopter.getPropellerNum());

        return helicopterDto;
    }

    public Helicopter helicopterDtoConvert (HelicopterDto helicopterDto){
        var helicopter = new Helicopter();

        helicopter.setType(helicopterDto.getType());
        helicopter.setColor(helicopterDto.getColor());
        helicopter.setBrand(helicopterDto.getBrand());
        helicopter.setWindowsNum(helicopterDto.getWindowsNum());
        helicopter.setDoorsNum(helicopterDto.getDoorsNum());
        helicopter.setPropellerNum(helicopterDto.getPropellerNum());

        return helicopter;
    }

    public Boolean validateHelicopterDto(HelicopterDto helicopterDto) {
        return helicopterDto.getBrand() != null ||
                helicopterDto.getType() != null ||
                helicopterDto.getColor() != null ||
                helicopterDto.getWindowsNum() != null ||
                helicopterDto.getPropellerNum() != null ||
                helicopterDto.getDoorsNum() != null;
    }

    public void createHelicopter(HelicopterDto helicopterDto) {
        if (validateHelicopterDto(helicopterDto)) {
            Helicopter helicopter = helicopterDtoConvert(helicopterDto);
            helicopterRepository.save(helicopter);
        }
        throw new RuntimeException(String.valueOf(helicopterDtoConvert(helicopterDto)));
    }

    public List<Helicopter> getAll(){
        return helicopterRepository.findAll();
    }

    public Helicopter getByVehicleId(String vehicleId){
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        UUID id = UUID.fromString(formattedUuid);
        return helicopterRepository.findByVehicleId(id)
                .orElse(new Helicopter());
    }

    public List<HelicopterDto> getByBrand(VehicleBrandEnum brand){
        List<Helicopter> helicopterList = helicopterRepository.findByBrand(brand);
        List<HelicopterDto> helicopterDtoList = new ArrayList<>();

        for (Helicopter helicopter : helicopterList) {
            HelicopterDto helicopterDto = helicopterConvertToDto(helicopter);
            helicopterDtoList.add(helicopterDto);
        }

        return helicopterDtoList;
    }

    public List<HelicopterDto> getByPropellerNum(Integer propellerNum){
        List<Helicopter> helicopterList = helicopterRepository.findByPropellerNum(propellerNum);
        List<HelicopterDto> helicopterDtoList = new ArrayList<>();

        for (Helicopter helicopter : helicopterList) {
            HelicopterDto helicopterDto = helicopterConvertToDto(helicopter);
            helicopterDtoList.add(helicopterDto);
        }

        return helicopterDtoList;
    }

    public HelicopterDto updateHelicopter(String vehicleId, HelicopterDto helicopterDto) {
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        UUID id = UUID.fromString(formattedUuid);

        Helicopter existingHelicopter = helicopterRepository.findByVehicleId(id)
                .orElseThrow(() -> new RuntimeException("Helicopter not found"));

        existingHelicopter.setType(helicopterDto.getType());
        existingHelicopter.setColor(helicopterDto.getColor());
        existingHelicopter.setBrand(helicopterDto.getBrand());
        existingHelicopter.setWindowsNum(helicopterDto.getWindowsNum());
        existingHelicopter.setDoorsNum(helicopterDto.getDoorsNum());
        existingHelicopter.setPropellerNum(helicopterDto.getPropellerNum());

        helicopterRepository.save(existingHelicopter);
        return helicopterConvertToDto(existingHelicopter);
    }

    public boolean deleteById(String vehicleId) {
        String formattedUuid = vehicleId.replaceFirst(
                "(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)",
                "$1-$2-$3-$4-$5"
        );
        UUID id = UUID.fromString(formattedUuid);

        Optional<Helicopter> helicopter = helicopterRepository.findByVehicleId(id);
        if (helicopter.isPresent()) {
            helicopterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}