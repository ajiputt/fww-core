package com.telkomsel.fww.core.service;

import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.model.ScheduleSeats;
import com.telkomsel.fww.core.repository.ReservationRepository;
import com.telkomsel.fww.core.repository.ScheduleSeatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    ReservationService reservationService;


    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private ScheduleSeatRepository scheduleSeatRepository;

    @BeforeEach
    void init() {
        reservationService = new ReservationService(reservationRepository,
                scheduleSeatRepository);
    }

    @Test
    void processSaveReservation() {
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookingCode("code")
                .status("B").build();
        ScheduleSeats seats = ScheduleSeats.builder()
                .seatNo(1)
                .id(1)
                .status("A").build();
        ScheduleSeats seatsResponse = ScheduleSeats.builder()
                .seatNo(1)
                .id(1)
                .status("B").build();

        when(reservationRepository.save(any())).thenReturn(reservation);
        when(scheduleSeatRepository.findByScheduleAvailableCodeAndSeatNo(any(), any())).thenReturn(seats);
        when(scheduleSeatRepository.save(any())).thenReturn(seatsResponse);

        Reservation resp = reservationService.processSaveReservation(Reservation.builder().build());

        assertEquals("B", resp.getStatus());
    }

    @Test
    void processUpdateReservation() {
        Reservation reservation = Reservation.builder()
                .id(1)
                .bookingCode("code")
                .status("E").build();
        ScheduleSeats seats = ScheduleSeats.builder()
                .seatNo(1)
                .id(1)
                .status("A").build();

        when(reservationRepository.save(any())).thenReturn(reservation);
        when(reservationRepository.findByBookingCode(any())).thenReturn(reservation);
        when(scheduleSeatRepository.findByScheduleAvailableCodeAndSeatNo(any(), any())).thenReturn(seats);
        when(scheduleSeatRepository.save(any())).thenReturn(seats);

        Reservation resp =
                reservationService.processUpdateReservation(Reservation.builder().status("E").build());

        assertEquals("E", resp.getStatus());
    }
}