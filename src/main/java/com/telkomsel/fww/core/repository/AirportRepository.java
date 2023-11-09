package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "airports", path = "airports")
public interface AirportRepository extends PagingAndSortingRepository<Airport
        , String>, CrudRepository<Airport, String> {
}
