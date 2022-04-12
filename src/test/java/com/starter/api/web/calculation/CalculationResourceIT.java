package com.starter.api.web.calculation;

import com.starter.api.expose.request.SumRequest;
import com.starter.api.expose.response.SumResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class CalculationResourceIT {

    //webEnvironment=RANDOM_PORT to start the server with a random port
    // (useful to avoid conflicts in test environments)
    // and the injection of the port with @LocalServerPort

    @LocalServerPort
    private int port;

    //Spring Boot has automatically provided a TestRestTemplate for you.
    //All you have to do is add @Autowired to it
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * We can say that it is a style/template how we can describe some functionality (system behavior) in more readable and natural for human way.
     * It is a part of BDD (Behavior-Driven Development).
     *
     * The **given** part describes the state of the world before you begin the behavior you're specifying in this scenario.
     * You can think of it as the pre-conditions to the test.
     *
     * The **when** section is that behavior that you're specifying.
     *
     * Finally the **then** section describes the changes you expect due to the specified behavior
     */
    @Test
    @DisplayName("Given: web server starts, When: two numbers pass to the sum web service, Then: sum of the passed two numbers return to the client")
    public void testSum(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        //given

        //when
        SumRequest request = new SumRequest();
        request.setNumberOne("1");
        request.setNumberTwo("100");

        String uri = "http://localhost:" + port + "/spring-boot-rest/calculations/sum";
        ResponseEntity<SumResponse> response = restTemplate.exchange(uri, HttpMethod.POST,
                new HttpEntity<>(request, getDefaultHttpHeaders()), SumResponse.class);

        //then
        Assertions.assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        Assertions.assertThat(Objects.requireNonNull(response.getBody()).getResult()).isEqualTo("101");

       /*
        if we want to see h2 console add to test.properties file following property and prevent web server shut down!
        spring.h2.console.enabled=true
        while(true) {
        }
        */
    }

    public HttpHeaders getDefaultHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
