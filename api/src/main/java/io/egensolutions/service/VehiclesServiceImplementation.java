package io.egensolutions.service;

import io.egensolutions.entities.vehicle.Vehicle;
import io.egensolutions.exception.BadRequestException;
import io.egensolutions.exception.ResourceNotFoundException;
import io.egensolutions.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehiclesServiceImplementation implements VehiclesService {

    @Autowired
    VehicleRepository vehicleRepository;
    VehiclesServiceImplementation(){
        System.out.println("Vehicle service");
    }
    @Transactional(readOnly = true)
    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAllVehicles();
    }

    @Transactional(readOnly = true)
    public Vehicle findOneVehicle(String vin) {
        Vehicle vehicle = vehicleRepository.findOneVehicle(vin);
        if(vehicle == null){
            //Throw ResourceNotFoundException Exception
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " not found in database");
        }
        return vehicle;
    }
    @Transactional
    public Vehicle createVehicle(Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findByModel(vehicle.getModel());
        if (existingVehicle!=null){
            throw new BadRequestException("Vehicle with " + vehicle.getModel() + "already exists");
        }
        return vehicleRepository.createVehicle(vehicle);
    }
    @Transactional
    public Vehicle updateVehicle(String vin, Vehicle vehicle) {
        try {
            Vehicle existingVehicle = vehicleRepository.findOneVehicle(vin);
            if (existingVehicle == null) {
                throw new ResourceNotFoundException("Vehicle with vin " + vin + " not found in database");
            }
        }
        catch(Exception e){
            System.out.println("ERROR IN VEH SERVICE");
        }
        return vehicleRepository.updateVehicle(vehicle);
    }
    @Transactional
    public void deleteVehicle(String vin) {

        Vehicle existingVehicle = vehicleRepository.findOneVehicle(vin);

        if(existingVehicle == null){
            throw new ResourceNotFoundException("Vehicle with vin " + vin + " not found in database");
        }
        vehicleRepository.deleteVehicle(vin);
    }
}
