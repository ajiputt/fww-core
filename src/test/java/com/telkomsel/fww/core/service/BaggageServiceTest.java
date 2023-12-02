package com.telkomsel.fww.core.service;

import com.telkomsel.fww.core.model.Baggage;
import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.repository.BaggageRepository;
import com.telkomsel.fww.core.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BaggageServiceTest {

    BaggageService baggageService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private BaggageRepository baggageRepository;

    @BeforeEach
    void init() {
        baggageService = new BaggageService(reservationRepository,
                baggageRepository);
    }

    @Test
    void processCheckin() {
        Baggage baggage = new Baggage("code", "bookingCode",
                new BigDecimal(1), "");
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookingCode("code")
                .status("B").build();

        when(baggageRepository.save(any())).thenReturn(baggage);
        when(reservationRepository.findByBookingCode(any())).thenReturn(reservation);
        when(reservationRepository.save(any())).thenReturn(reservation);


        Baggage resp = baggageService.processCheckin(baggage);

        assertEquals(baggage.getCode(), resp.getCode());
    }
}