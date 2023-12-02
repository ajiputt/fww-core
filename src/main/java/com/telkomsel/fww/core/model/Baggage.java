package com.telkomsel.fww.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "baggages")
public class Baggage {

    @Id
    private String code;

    private String bookingCode;

    private BigDecimal weight;

    private String description;
}
