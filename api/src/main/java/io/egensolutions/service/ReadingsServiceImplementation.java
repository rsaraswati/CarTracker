package io.egensolutions.service;

import io.egensolutions.entities.alerts.Alerts;
import io.egensolutions.entities.readings.Reading;
import io.egensolutions.entities.vehicle.Vehicle;
import io.egensolutions.exception.ResourceNotFoundException;
import io.egensolutions.repository.ReadingsRepository;
import io.egensolutions.repository.ReadingsRepositoryImplementation;
import io.egensolutions.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ReadingsServiceImplementation implements ReadingsService{
    @Autowired
    ReadingsRepository readingsRepository;
    @Autowired
    VehicleRepository vehicleRepository;
    private EntityManager entityManager;
    ReadingsServiceImplementation(){
        System.out.println("Reading service");
    }

    @Transactional(readOnly = true)
    public List<Reading> findAllReadings() {
        return readingsRepository.findAllReadings();
    }

    @Transactional(readOnly = true)
    public Reading findOneReading(String vin) {
        Reading reading = readingsRepository.findOneReading(vin);
        if(reading == null){
            //Throw ResourceNotFoundException Exception
            throw new ResourceNotFoundException("Reading with vin " + vin + " not found in database");
        }
        return reading;
    }
    @Transactional
    public Reading createReading(Reading reading) {
       /* Reading existingReading = readingsRepository.findByTimestamp(reading.getTimestamp());
        if (existingReading==null){
            throw new BadRequestException("Reading with timestamp" + reading.getTimestamp() + "already exists");
        } */
        return readingsRepository.createReading(reading);
    }
    @Transactional
    public Reading updateReading(String vin, Reading reading) {

        Vehicle veh = vehicleRepository.findOneVehicle(vin);
        if(reading.getEngineRpm() > veh.getRedlineRpm()) {
            Alerts engineRpmAlert = new Alerts();
            engineRpmAlert.setId(1);
            engineRpmAlert.setMessage("Engine RPM is greater than read line RPM! Check your car!");
            engineRpmAlert.setPriority("HIGH");
            createAlerts(engineRpmAlert);
        }
        if(reading.getFuelVolume() < 0.1 * veh.getMaxFuelVolume()){
            Alerts fuelVolumeAlert = new Alerts();
            fuelVolumeAlert.setId(1);
            fuelVolumeAlert.setMessage("Engine RPM is greater than read line RPM! Check your car!");
            fuelVolumeAlert.setPriority("HIGH");
            createAlerts(fuelVolumeAlert);
        }
        if((reading.getFrontLeft() < 32 || reading.getFrontLeft() > 36) ||
                (reading.getFrontRight() < 32 || reading.getFrontRight() > 36) ||
                (reading.getRearLeft() < 32 || reading.getRearLeft() > 36) ||
                (reading.getRearRight() < 32 || reading.getRearRight() > 36)){
            Alerts tireAlert = new Alerts();
            tireAlert.setId(3);
            tireAlert.setMessage("Tire pressure problem! Check your tires!");
            tireAlert.setPriority("LOW");
            createAlerts(tireAlert);
        }
        if(reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()){
            Alerts engineStatsAlert = new Alerts();
            engineStatsAlert.setId(4);
            engineStatsAlert.setMessage("Either engine coolant is low or engine light is on");
            engineStatsAlert.setPriority("LOW");
            createAlerts(engineStatsAlert);
        }
        Reading existingReading = readingsRepository.findOneReading(vin);
        if(existingReading == null){
            //insert
            return readingsRepository.createReading(reading);
        }
        else {
            //update
            return readingsRepository.updateReading(existingReading);
        }
    }

    public void createAlerts(Alerts alerts){
        entityManager.persist(alerts);
    }


    @Transactional
    public void deleteReading(String vin) {

        Reading existingReading = readingsRepository.findOneReading(vin);

        if(existingReading == null){
            throw new ResourceNotFoundException("Reading with vin " + vin + " not found in database");
        }
        readingsRepository.deleteReading(vin);
    }
}
