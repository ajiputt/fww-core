package com.telkomsel.fww.core.projection;

import com.telkomsel.fww.core.model.Airport;
import com.telkomsel.fww.core.model.Plane;
import com.telkomsel.fww.core.model.Schedule;
import com.telkomsel.fww.core.model.ScheduleSeats;
import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Projection(name = "schedule-view", types = Schedule.class)
public interface ScheduleView {

    String getCode();

    LocalDate getDate();

    LocalTime getTimeDeparture();

    Integer getDuration();

    Integer getBaggageWeight();

    BigDecimal getPrice();

    Airport getAirportDeparture();

    Airport getAirportArrival();

    Plane getPlane();

    List<ScheduleSeats> getAvailableSeats();
}
