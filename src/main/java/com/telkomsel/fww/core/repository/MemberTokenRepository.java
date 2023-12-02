package com.telkomsel.fww.core.repository;

import com.telkomsel.fww.core.model.MemberToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "member_token", path =
        "member-token")
public interface MemberTokenRepository extends PagingAndSortingRepository<MemberToken
        , String>, CrudRepository<MemberToken, String> {

    Boolean existsByUsernameAndToken(String username, String token);
}
