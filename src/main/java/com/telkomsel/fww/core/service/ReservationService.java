package com.telkomsel.fww.core.service;

import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.model.ScheduleSeats;
import com.telkomsel.fww.core.repository.ReservationRepository;
import com.telkomsel.fww.core.repository.ScheduleSeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ScheduleSeatRepository scheduleSeatRepository;


    public ReservationService(ReservationRepository reservationRepository, ScheduleSeatRepository scheduleSeatRepository) {
        this.reservationRepository = reservationRepository;
        this.scheduleSeatRepository = scheduleSeatRepository;
    }

    @Transactional
    public Reservation processSaveReservation(Reservation reservation) {
        Reservation resp = reservationRepository.save(reservation);
        ScheduleSeats seats =
                scheduleSeatRepository.findByScheduleAvailableCodeAndSeatNo(reservation.getScheduleCode(), reservation.getSeatNo());
        if (seats == null || !seats.getStatus().equals("A")) {
            throw new RuntimeException("Throwing exception for rollback");
        } else {
            seats.setStatus(reservation.getStatus());
            scheduleSeatRepository.save(seats);
        }
        return resp;
    }

    @Transactional
    public Reservation processUpdateReservation(Reservation reservation) {
        Reservation reservation1 =
                reservationRepository.findByBookingCode(reservation.getBookingCode());
        reservation1.setStatus(reservation.getStatus());
        Reservation resp = reservationRepository.save(reservation1);

        if (resp.getStatus().equals("E") || resp.getStatus().equals("C")) {
            ScheduleSeats seats =
                    scheduleSeatRepository.findByScheduleAvailableCodeAndSeatNo(resp.getScheduleCode(), resp.getSeatNo());

            seats.setStatus("A");
            scheduleSeatRepository.save(seats);
        }
        resp.setSchedule(null);
        return resp;
    }
}
