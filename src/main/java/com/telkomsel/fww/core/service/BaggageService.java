package com.telkomsel.fww.core.service;

import com.telkomsel.fww.core.model.Baggage;
import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.repository.BaggageRepository;
import com.telkomsel.fww.core.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaggageService {

    private final ReservationRepository reservationRepository;

    private final BaggageRepository baggageRepository;


    public BaggageService(ReservationRepository reservationRepository, BaggageRepository baggageRepository) {
        this.reservationRepository = reservationRepository;
        this.baggageRepository = baggageRepository;
    }

    @Transactional
    public Baggage processCheckin(Baggage baggage) {

        Baggage resp = baggageRepository.save(baggage);
        Reservation reservation =
                reservationRepository.findByBookingCode(baggage.getBookingCode());

        reservation.setStatus("D");
        reservationRepository.save(reservation);

        return resp;
    }

}
