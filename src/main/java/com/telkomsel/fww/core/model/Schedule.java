package com.telkomsel.fww.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    private String code;

    private LocalDate date;

    private LocalTime timeDeparture;

    private Integer duration;

    private Integer baggageWeight;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "planes_code")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "airport_departure")
    private Airport airportDeparture;

    @ManyToOne
    @JoinColumn(name = "airport_arrival")
    private Airport airportArrival;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleAvailable")
    @Where(clause = "status = 'A'")
    private List<ScheduleSeats> availableSeats;

}
