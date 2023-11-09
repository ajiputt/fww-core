package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "members", path = "members")
public interface MemberRepository extends PagingAndSortingRepository<Member
        , String>, CrudRepository<Member, String> {
}
