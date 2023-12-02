package com.telkomsel.fww.core.projection;

import com.telkomsel.fww.core.model.Member;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "member-view", types = Member.class)
public interface MemberView {

    String getUsername();

    String getPassword();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhone();

    String getAddress();

}
