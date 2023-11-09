package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Airport;
import com.telkomsel.fww.core.model.Schedule;
import com.telkomsel.fww.core.model.ScheduleSeats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "schedules", path = "schedules")
public interface ScheduleRepository extends PagingAndSortingRepository<Schedule
        , String>, CrudRepository<Schedule, String> {
}
