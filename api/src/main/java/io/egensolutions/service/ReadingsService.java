package io.egensolutions.service;


import io.egensolutions.entities.readings.Reading;

import java.util.List;

public interface ReadingsService {

    List<Reading> findAllReadings();

    Reading findOneReading(String vin);

    Reading createReading(Reading reading);

    Reading updateReading(String vin, Reading reading);

    void deleteReading(String vin);
}
