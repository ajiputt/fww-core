package com.telkomsel.fww.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planes")
public class Plane {


    @Id
    private String code;

    private String name;

    private Integer noOfSeats;

}
