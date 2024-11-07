package com.factory.pattern.controller.vehicle.air;

import com.factory.pattern.base.ApiResponse;
import com.factory.pattern.base.SystemMessages;
import com.factory.pattern.entity.dto.vehicle.air.HelicopterDto;
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
            List<HelicopterDto> helicopters = helicopterService.getAll();
            if (helicopters.isEmpty()){
                return new ApiResponse(helicopters, SystemMessages.Helicopter.NO_VEHICLE);
            }
            return new ApiResponse(helicopters, SystemMessages.Helicopter.SUCCESS_GOT);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }
}



