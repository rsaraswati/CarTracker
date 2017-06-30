package io.egensolutions.repository;

import io.egensolutions.entities.vehicle.Vehicle;

import java.util.List;

/**
 * Created by Rumela on 6/27/2017.
 */
public interface VehicleRepository {

    List<Vehicle> findAllVehicles();

    Vehicle findOneVehicle(String vin);

    Vehicle findByModel(String model);

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    void deleteVehicle(String vin);
}
