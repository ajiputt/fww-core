package com.telkomsel.fww.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookingCode;

    private String createdBy;

    private LocalDateTime createdAt = LocalDateTime.now();

    private String status;

    private Integer seatNo;

    @Basic(optional = false)
    @Column(name = "schedule_code")
    private String scheduleCode;

    @Basic(optional = false)
    @Column(name = "nik")
    private String nik;

    @JoinColumn(name = "schedule_code", referencedColumnName = "code",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Schedule schedule;

    @JoinColumn(name = "nik", referencedColumnName = "nik",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Passenger passenger;
}
