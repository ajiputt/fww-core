package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.ScheduleSeats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "schedule-seats", path =
        "schedules-seats")
public interface ScheduleSeatRepository extends PagingAndSortingRepository<ScheduleSeats
        , Integer>, CrudRepository<ScheduleSeats, Integer> {

    ScheduleSeats findByScheduleAvailableCodeAndSeatNo(String scheduleCode,
                                                       Integer seatNo);

}
