package com.factory.pattern.service.vehicle.air;

import com.factory.pattern.entity.dto.vehicle.air.HelicopterDto;
import com.factory.pattern.entity.vehicles.air.Helicopter;
import com.factory.pattern.repository.vehicle.air.HelicopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<HelicopterDto> getAll(){
        List<Helicopter> helicopters = helicopterRepository.findAll();
        List<HelicopterDto> helicoptersDto = new ArrayList<>();

        for (Helicopter helicopter : helicopters) {
            HelicopterDto helicopterDto = helicopterConvertToDto(helicopter);
            helicoptersDto.add(helicopterDto);
        }

        return helicoptersDto;
    }


}