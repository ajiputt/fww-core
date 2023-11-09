package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Airport;
import com.telkomsel.fww.core.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "reservations", path =
        "reservations")
public interface ReservationRepository extends PagingAndSortingRepository<Reservation
        , Integer>, CrudRepository<Reservation, Integer> {
}
