package com.telkomsel.fww.core.controller;

import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(value = "/reservations/update", produces = "application/json")
    public ResponseEntity<Object> updateReservation(@RequestBody Reservation reservation) {

        try {
            Reservation resp =
                    reservationService.processUpdateReservation(reservation);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Update Failed",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
