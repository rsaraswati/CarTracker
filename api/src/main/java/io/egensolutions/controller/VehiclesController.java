package io.egensolutions.controller;

import io.egensolutions.entities.vehicle.Vehicle;
import io.egensolutions.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io")
@RestController
@RequestMapping(value = "/vehicles")
public class VehiclesController {

    @Autowired
    VehiclesService vehiclesService;

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAllVehicles(){
        System.out.println("Vehicles 2");
        return vehiclesService.findAllVehicles();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{vin}",
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOneVehicle(@PathVariable("vin") String vin){
        return vehiclesService.findOneVehicle(vin);
    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        System.out.println("Vehicles 4");
        return vehiclesService.createVehicle(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{vin}",
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
      public Vehicle updateVehicle (@PathVariable("vin") String vin, @RequestBody Vehicle vehicle) {
        System.out.println("Vehicles 3");
            return vehiclesService.updateVehicle(vin, vehicle);

    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{vin}")
    public void deleteVehicle(@PathVariable("vin") String vin){
        vehiclesService.deleteVehicle(vin);
    }
}
