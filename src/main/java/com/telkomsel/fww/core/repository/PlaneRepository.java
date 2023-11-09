package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "planes", path = "planes")
public interface PlaneRepository extends PagingAndSortingRepository<Plane
        , String>, CrudRepository<Plane, String> {
}
