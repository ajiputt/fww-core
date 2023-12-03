package com.telkomsel.fww.core.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(value = ReservationController.class, excludeAutoConfiguration =
        {SecurityAutoConfiguration.class})
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    SecurityContext securityContext;

    @Mock
    Authentication auth;

    @MockBean
    private ReservationService reservationService;

    @BeforeEach
    void init() {
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void updateReservation() throws Exception {
        String role = "TESTING_ROLE";
        Collection authorities;
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        UserDetails loggedInUser;
        loggedInUser = User.withUsername("username")
                .password("password")
                .roles("ADMIN")
                .build();
        when(securityContext.getAuthentication()).thenReturn(auth);
        when(auth.getAuthorities()).thenReturn(authorities);
        when(auth.getPrincipal()).thenReturn(loggedInUser);

        Reservation reservation =
                Reservation.builder().bookingCode("TEST-001").nik("123213").build();
        when(reservationService.processUpdateReservation(any())).thenReturn(reservation);

        mockMvc.perform(MockMvcRequestBuilders.post("/reservations/update").accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservation)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}