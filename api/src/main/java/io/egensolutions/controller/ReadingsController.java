package io.egensolutions.controller;

import io.egensolutions.entities.readings.Reading;
import io.egensolutions.service.ReadingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://mocker.egen.io")
@RestController
@RequestMapping(value = "/readings")
public class ReadingsController {
    @Autowired
    ReadingsService readingsService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Reading> findAllReadings(){
          return readingsService.findAllReadings();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading findOneReading(@PathVariable("vin") String vin){
          return readingsService.findOneReading(vin);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading createReading(@RequestBody Reading reading){
           return readingsService.createReading(reading);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Reading updateReading(@PathVariable("vin") String vin, @RequestBody Reading reading){

           return readingsService.updateReading(vin,reading);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{vin}")
    public void deleteReading(@PathVariable("vin") String vin){
        readingsService.deleteReading(vin);
    }
}
