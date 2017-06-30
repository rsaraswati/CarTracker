package io.egensolutions.entities.vehicle;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(schema = "vehicles_db")
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAllVehicles",
                    query = "SELECT vehicle FROM Vehicle vehicle ORDER BY vehicle.make"),
        @NamedQuery(name = "Vehicle.findByModel",
                    query = "SELECT vehicle FROM Vehicle vehicle WHERE vehicle.model=:modelParameter"),
        })
public class Vehicle {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String vin;
    @Column(columnDefinition = "VARCHAR(100)")
    private String make;
    @Column(unique = true)
    private String model;
    @Column(columnDefinition = "INT(4)")
    private int year;
    @Column(columnDefinition = "INT(5)")
    private int redlineRpm;
    @Column(columnDefinition = "INT(3)")
    private int maxFuelVolume;
    private Timestamp lastServiceDate;

    public Vehicle(){
        System.out.println("Vehicle 1");
        this.vin = UUID.randomUUID().toString();
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public int getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(int maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    @Override
    public String toString() {
        return "Vehicles{" + "vin='" + vin + '\''
                        + ", make='" + make + '\''
                        + ", model='" + model + '\''
                        + ", year=" + year
                        + ", redlineRpm=" + redlineRpm
                        + ", maxFuelVolume=" + maxFuelVolume
                        + ", lastServiceDate='" + lastServiceDate + '\''
                        + '}';
    }
}
