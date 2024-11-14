package com.factory.pattern.controller.vehicle.air;

import com.factory.pattern.base.ApiResponse;
import com.factory.pattern.base.SystemMessages;
import com.factory.pattern.entity.dto.vehicle.air.HelicopterDto;
import com.factory.pattern.entity.enums.vehicle.VehicleBrandEnum;
import com.factory.pattern.entity.vehicles.air.Helicopter;
import com.factory.pattern.service.vehicle.air.HelicopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/helicopter")
public class HelicopterController {

    @Autowired
    HelicopterService helicopterService;

    @PostMapping("/create")
    public ApiResponse create(@RequestBody HelicopterDto helicopterDto) {
        try {
            if (helicopterService.validateHelicopterDto(helicopterDto)){
                helicopterService.createHelicopter(helicopterDto);
                return new ApiResponse(helicopterDto, SystemMessages.Helicopter.SUCCESS_CREATED);
            }
            return new ApiResponse(helicopterDto, SystemMessages.Helicopter.MISSING_VALUES);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/all")
    public ApiResponse getAll(){
        try {
            List<Helicopter> helicopters = helicopterService.getAll();
            if (helicopters.isEmpty()){
                return new ApiResponse(helicopters, SystemMessages.Helicopter.NO_VEHICLE);
            }
            return new ApiResponse(helicopters, SystemMessages.Helicopter.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/id/{vehicleId}")
    public ApiResponse getByVehicleId (@PathVariable String vehicleId){
        try {
            Helicopter helicopter = helicopterService.getByVehicleId(vehicleId);

            if (helicopter.equals(new Helicopter())){
                return new ApiResponse(helicopter, SystemMessages.Helicopter.NOT_FOUND);
            }

            return new ApiResponse(helicopter, SystemMessages.Helicopter.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/brand/{brand}")
    public ApiResponse getByBrand (@PathVariable VehicleBrandEnum brand){
        try {
            List<HelicopterDto> helicopter = helicopterService.getByBrand(brand);

            if (helicopter.isEmpty()){
                return new ApiResponse(helicopter, SystemMessages.Helicopter.NOT_FOUND);
            }

            return new ApiResponse(helicopter, SystemMessages.Helicopter.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/propeller/{propellerNum}")
    public ApiResponse getByPropellerNum (@RequestBody Integer propellerNum){
        try {
            List<HelicopterDto> helicopter = helicopterService.getByPropellerNum(propellerNum);

            if (helicopter.isEmpty()){
                return new ApiResponse(helicopter, SystemMessages.Helicopter.NOT_FOUND);
            }

            return new ApiResponse(helicopter, SystemMessages.Helicopter.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @PutMapping("/update/{vehicleId}")
    public ApiResponse update(@PathVariable String vehicleId, @RequestBody HelicopterDto helicopterDto) {
        try {
            if (helicopterService.validateHelicopterDto(helicopterDto)) {
                HelicopterDto updatedHelicopter = helicopterService.updateHelicopter(vehicleId, helicopterDto);
                return new ApiResponse(updatedHelicopter, SystemMessages.Helicopter.SUCCESS_UPDATED);
            }
            return new ApiResponse(helicopterDto, SystemMessages.Helicopter.MISSING_VALUES);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @DeleteMapping("/delete/{vehicleId}")
    public ApiResponse deleteById(@PathVariable String vehicleId) {
        try {
            boolean isDeleted = helicopterService.deleteById(vehicleId);
            if (isDeleted) {
                return new ApiResponse(null, SystemMessages.Helicopter.SUCCESS_DELETED);
            }
            return new ApiResponse(null, SystemMessages.Helicopter.NOT_FOUND);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }
}



