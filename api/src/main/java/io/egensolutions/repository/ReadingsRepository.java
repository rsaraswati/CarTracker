package io.egensolutions.repository;

import io.egensolutions.entities.readings.Reading;

import java.sql.Timestamp;
import java.util.List;


public interface ReadingsRepository {

    List<Reading> findAllReadings();

    Reading findOneReading(String vin);

    Reading findByTimestamp(Timestamp timestamp);

    Reading createReading(Reading reading);

    Reading updateReading(Reading reading);

    void deleteReading(String vin);

}

