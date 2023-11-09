package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "passengers", path = "passengers")
public interface PassengerRepository extends PagingAndSortingRepository<Passenger
        , String>, CrudRepository<Passenger, String> {
}
