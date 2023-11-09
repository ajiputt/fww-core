package com.telkomsel.fww.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    private Integer id;

    private String bookingCode;

    private String routeCode;

    private String nik;

    private String createdBy;

    private LocalDateTime createdAt;
}
