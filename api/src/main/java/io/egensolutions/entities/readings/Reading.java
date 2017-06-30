package io.egensolutions.entities.readings;

import io.egensolutions.entities.alerts.Alerts;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(schema = "readings_db")
@NamedQueries({
        @NamedQuery(name = "Reading.findAllReadings",
                query = "SELECT readings FROM Reading readings ORDER BY readings.timestamp ASC"),
        @NamedQuery(name = "Reading.findByTimestamp",
                query = "SELECT readings FROM Reading readings WHERE readings.timestamp=:timestampParameter"),
})
public class Reading {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String vin;

    private float latitude;
    private float longitude;

    @Column(nullable = false)
    private Timestamp timestamp;

    private float fuelVolume;
    private int speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private int engineRpm;
    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;
/*
    @EmbeddedId
    private FKImplementation fkImplementation;
*/
    /*@OneToOne
    private Alerts alerts;
    */
    public Reading() {
        this.vin = UUID.randomUUID().toString();
        System.out.println(vin);
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
  /*  public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }*/

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

  /*  public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }
    */
    /*public FKImplementation getFkImplementation() {
        return fkImplementation;
    }

    public void setFkImplementation(FKImplementation fkImplementation) {
        this.fkImplementation = fkImplementation;
    }
*/
    @Override
    public String toString() {
        return "Reading{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                //", fkImplementation=" + fkImplementation +
                '}';
    }
}

