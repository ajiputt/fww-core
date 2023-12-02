package com.telkomsel.fww.core.controller;

import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.service.ReservationService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
public class ReservationCustomController {

    private final ReservationService reservationService;

    public ReservationCustomController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping(value = "/reservations")
    public ResponseEntity<Object> postReservation(@RequestBody Reservation reservation) {

        try {
            Reservation resp =
                    reservationService.processSaveReservation(reservation);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Seats Unavailable",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
