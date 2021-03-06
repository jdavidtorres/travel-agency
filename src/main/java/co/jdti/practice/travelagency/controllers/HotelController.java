package co.jdti.practice.travelagency.controllers;

import co.jdti.practice.travelagency.dtos.HotelDto;
import co.jdti.practice.travelagency.services.IHotelServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel-data")
@CrossOrigin("*")
public class HotelController {

    private static final Logger log = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private IHotelServices iHotelServices;

    @GetMapping("/info/{id}")
    public ResponseEntity<HotelDto> getHotelData(@PathVariable String id) {
        return new ResponseEntity<>(iHotelServices.getHotelInfo(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HotelDto>> getAllHotels() {
        return new ResponseEntity<>(iHotelServices.getAll(), HttpStatus.OK);
    }
}
