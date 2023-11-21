package com.telkomsel.fww.core.airport;

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
public class AirportDataRestTest {

    @Autowired
    TestRestTemplate template;

    private static final String AIRPORT_ENDPOINT = "http://localhost:8081" +
            "/airports";

    @Test
    public void givenAuthRequestOnAirport_shouldSucceedWith200() throws Exception {
        ResponseEntity<Object> result = template.withBasicAuth("test",
                        "test")
                .getForEntity(AIRPORT_ENDPOINT, Object.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.toString().contains("code"));
        assertTrue(result.toString().contains("name"));
        assertTrue(result.toString().contains("city"));
    }


}
