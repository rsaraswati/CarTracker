package io.egensolutions.service;

import io.egensolutions.entities.vehicle.Vehicle;

import java.util.List;

public interface VehiclesService {

     List<Vehicle> findAllVehicles();

     Vehicle findOneVehicle(String vin);

     Vehicle createVehicle(Vehicle vehicle);

     Vehicle updateVehicle(String vin, Vehicle vehicle);

     void deleteVehicle(String vin);
}
