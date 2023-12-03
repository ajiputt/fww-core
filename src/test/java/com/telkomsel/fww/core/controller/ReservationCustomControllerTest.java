package com.telkomsel.fww.core.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkomsel.fww.core.model.Baggage;
import com.telkomsel.fww.core.model.Reservation;
import com.telkomsel.fww.core.service.BaggageService;
import com.telkomsel.fww.core.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class ReservationCustomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @MockBean
    private ReservationService reservationService;

    @Test
    void postReservation() throws Exception {
        Reservation reservation =
                Reservation.builder().bookingCode("TEST-001").nik("123213").build();
        when(reservationService.processSaveReservation(any())).thenReturn(reservation);

        mockMvc.perform(MockMvcRequestBuilders.post("/reservations")
                        .with(user("test").password("test").roles("USER",
                                "ADMIN"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservation)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @MockBean
    private BaggageService baggageService;

    @Test
    void postBaggages() throws Exception {

        Baggage baggage =
                Baggage.builder().bookingCode("TEST-001").code("BAGGAGE-001").build();
        when(baggageService.processCheckin(any())).thenReturn(baggage);

        mockMvc.perform(MockMvcRequestBuilders.post("/baggages")
                        .with(user("test").password("test").roles("USER",
                                "ADMIN"))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(baggage)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}