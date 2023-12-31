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
@Table(name = "passengers")
public class Passenger {

    @Id
    private String nik;

    private String fullName;

    private String title;

    private LocalDateTime createdAt;

}
