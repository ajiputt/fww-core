package com.telkomsel.fww.core.controller;

import com.telkomsel.fww.core.model.Baggage;
import com.telkomsel.fww.core.service.BaggageService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
public class BaggageCustomController {

    private final BaggageService baggageService;

    public BaggageCustomController(BaggageService baggageService) {
        this.baggageService = baggageService;
    }

    @PostMapping(value = "/baggages")
    public ResponseEntity<Object> postReservation(@RequestBody Baggage baggage) {

        try {
            Baggage resp =
                    baggageService.processCheckin(baggage);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Checkin Failed",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
