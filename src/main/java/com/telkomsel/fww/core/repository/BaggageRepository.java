package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Baggage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "baggages", path = "baggages")
public interface BaggageRepository extends PagingAndSortingRepository<Baggage
        , String>, CrudRepository<Baggage, String> {

}
