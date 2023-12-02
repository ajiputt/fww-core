package com.telkomsel.fww.core.reservation;

import com.telkomsel.fww.core.FwwCoreApplication;
import com.telkomsel.fww.core.model.Baggage;
import com.telkomsel.fww.core.model.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FwwCoreApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReservationDataRestTest {

    @Autowired
    TestRestTemplate template;

    private static final String RESERVATION_POST_ENDPOINT = "http://localhost:8081/reservations";

    private static final String RESERVATION_CHECKIN_ENDPOINT = "http" +
            "://localhost:8081/baggages";

    private static final String RESERVATION_GET_BY_CODE_ENDPOINT = "http" +
            "://localhost:8081/reservations/search/" +
            "findByBookingCode?projection=reservation-view&booking=BOOKING-001";
    private static final String RESERVATION_GET_BY_USER_ENDPOINT = "http" +
            "://localhost:8081/" +
            "reservations/search/findByCreatedBy?projection=reservation-view" +
            "&username=user-test";

    @Test
    public void givenAuthRequestOnPostReservation_shouldSucceedWith200() throws Exception {
        Reservation request = new Reservation();
        request.setBookingCode("BOOKING-002");
        request.setNik("123444432121");
        request.setStatus("B");
        request.setCreatedBy("user-test");
        request.setSeatNo(1);
        request.setScheduleCode("TEST-0002");
        ResponseEntity<Object> result = template.withBasicAuth("test",
                        "test")
                .postForEntity(RESERVATION_POST_ENDPOINT, request,
                        Object.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.toString().contains("BOOKING-002"));
    }

    @Test
    public void givenAuthRequestOnPostReservation_shouldSucceedWith500() throws Exception {
        Reservation request = new Reservation();
        request.setBookingCode("BOOKING-002");
        request.setNik("123444432121");
        request.setStatus("B");
        request.setCreatedBy("user-test");
        request.setSeatNo(1);
        request.setScheduleCode("TEST-0001");
        ResponseEntity<Object> result = template.withBasicAuth("test",
                        "test")
                .postForEntity(RESERVATION_POST_ENDPOINT, request,
                        Object.class);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, result.getStatusCode());
        assertTrue(result.toString().contains("Seats Unavailable"));
    }

    @Test
    public void givenAuthRequestOnReservationByCode_shouldSucceedWith200() throws Exception {
        ResponseEntity<Object> result = template.withBasicAuth("test",
                        "test")
                .getForEntity(RESERVATION_GET_BY_CODE_ENDPOINT, Object.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.toString().contains("TEST FULL NAME"));
        assertTrue(result.toString().contains("user-test"));
        assertTrue(result.toString().contains("10:00:00"));
    }

    @Test
    public void givenAuthRequestOnReservationByUser_shouldSucceedWith200() throws Exception {
        ResponseEntity<Object> result = template.withBasicAuth("test",
                        "test")
                .getForEntity(RESERVATION_GET_BY_USER_ENDPOINT, Object.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.toString().contains("TEST FULL NAME"));
        assertTrue(result.toString().contains("user-test"));
        assertTrue(result.toString().contains("10:00:00"));
    }

    @Test
    public void givenAuthRequestOnPostBaggages_shouldSucceedWith200() throws Exception {
        Baggage request = new Baggage();
        request.setBookingCode("BOOKING-001");
        request.setCode("TEST");
        request.setWeight(new BigDecimal(1));
        request.setDescription("A");
        ResponseEntity<Object> result = template.withBasicAuth("test",
                        "test")
                .postForEntity(RESERVATION_CHECKIN_ENDPOINT, request,
                        Object.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.toString().contains("BOOKING-001"));
    }


}
