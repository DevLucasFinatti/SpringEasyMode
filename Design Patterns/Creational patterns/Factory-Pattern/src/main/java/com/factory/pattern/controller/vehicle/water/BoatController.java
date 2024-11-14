package com.factory.pattern.controller.vehicle.water;

import com.factory.pattern.base.ApiResponse;
import com.factory.pattern.base.SystemMessages;
import com.factory.pattern.entity.dto.vehicle.water.BoatDto;
import com.factory.pattern.entity.vehicles.water.Boat;
import com.factory.pattern.service.vehicle.water.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boat")
public class BoatController {

    @Autowired
    private BoatService boatService;

    @PostMapping("/create")
    public ApiResponse createBoat(@RequestBody BoatDto boatDto) {
        try {
            boatService.createBoat(boatDto);
            return new ApiResponse(boatDto, SystemMessages.Boat.SUCCESS_CREATED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public ApiResponse getById(@PathVariable String id) {
        try {
            Boat boat = (Boat) boatService.getById(id);
            if (boat == null) {
                return new ApiResponse(null, SystemMessages.Boat.NOT_FOUND);
            }
            return new ApiResponse(boatService.convertToBoatDto(boat), SystemMessages.Boat.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/all")
    public ApiResponse getAll() {
        try {
            List<Boat> boats = boatService.getAll();
            if (boats.isEmpty()) {
                return new ApiResponse(boats, SystemMessages.Boat.NO_VEHICLE);
            }
            return new ApiResponse(boats, SystemMessages.Boat.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/hasMotor/{hasMotor}")
    public ApiResponse getByHasMotor(@PathVariable Boolean hasMotor) {
        try {
            List<BoatDto> boats = boatService.getAllByHasMotor(hasMotor);
            if (boats.isEmpty()) {
                return new ApiResponse(boats, SystemMessages.Boat.NO_VEHICLE);
            }
            return new ApiResponse(boats, SystemMessages.Boat.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @GetMapping("/sailsNum/{sailsNum}")
    public ApiResponse getBySailsNum(@PathVariable Integer sailsNum) {
        try {
            List<BoatDto> boats = boatService.getAllBySailsNum(sailsNum);
            if (boats.isEmpty()) {
                return new ApiResponse(boats, SystemMessages.Boat.NO_VEHICLE);
            }
            return new ApiResponse(boats, SystemMessages.Boat.SUCCESS_RETRIEVED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteById(@PathVariable String id) {
        try {
            boatService.deleteById(id);
            return new ApiResponse(null, SystemMessages.Boat.SUCCESS_DELETED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateById(@PathVariable String id, @RequestBody BoatDto boatDto) {
        try {
            Boat updatedBoat = boatService.updateById(id, boatDto);
            if (updatedBoat == null) {
                return new ApiResponse(null, SystemMessages.Boat.NOT_FOUND);
            }
            return new ApiResponse(boatService.convertToBoatDto(updatedBoat), SystemMessages.Boat.SUCCESS_UPDATED);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), SystemMessages.System.DYNAMIC_ERROR);
        }
    }
}
