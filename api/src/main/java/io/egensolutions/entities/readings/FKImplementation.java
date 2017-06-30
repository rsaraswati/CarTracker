package io.egensolutions.entities.readings;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Embeddable
public class FKImplementation {

    private Timestamp timestamp;
    private String vin;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
