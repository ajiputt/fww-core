package com.telkomsel.fww.core.projection;

import com.telkomsel.fww.core.model.Passenger;
import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.model.Schedule;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "reservation-view", types = Reservation.class)
public interface ReservationView {

    String getBookingCode();

    Passenger getPassenger();

    Schedule getSchedule();

    String getCreatedBy();

    LocalDateTime getCreatedAt();
}
