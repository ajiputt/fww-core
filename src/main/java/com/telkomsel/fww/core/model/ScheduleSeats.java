package com.telkomsel.fww.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "schedule_seats")
public class ScheduleSeats {

    @Id
    private Integer id;

    private Integer seatNo;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_code")
    private Schedule scheduleAvailable;
}
