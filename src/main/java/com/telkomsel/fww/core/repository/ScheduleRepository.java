package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "schedules", path = "schedules")
public interface ScheduleRepository extends PagingAndSortingRepository<Schedule
        , String>, CrudRepository<Schedule, String> {

    List<Schedule> findByAirportDepartureCodeAndAirportArrivalCodeAndDate(String departure, String arrival, LocalDate date);
}
