package com.telkomsel.fww.core.schedule;

import com.telkomsel.fww.core.FwwCoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FwwCoreApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ScheduleDataRestTest {

    @Autowired
    TestRestTemplate template;

    private static final String SCHEDULE_ENDPOINT = "http://localhost:8081/schedules/search/" +
            "findByAirportDepartureCodeAndAirportArrivalCodeAndDate?projection=schedule-view" +
            "&departure=001&arrival=003&date=2023-12-25";

    @Test
    public void givenAuthRequestOnSchedule_shouldSucceedWith200() throws Exception {
        ResponseEntity<Object> result = template.withBasicAuth("test",
                        "test")
                .getForEntity(SCHEDULE_ENDPOINT, Object.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.toString().contains("plane"));
        assertTrue(result.toString().contains("available_seats"));
        assertTrue(result.toString().contains("airport_departure"));
    }


}
