package com.starter.api.web.calculation;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.starter.api.expose.request.SumRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

//@AutoConfigureMockMvc: Use this when you just want to configure MockMvc,
// Enables all auto-configuration related to MockMvc and ONLY MockMvc. Again, this is a subset of overall auto-configuration.
//It includes the following auto-configuration (see spring.factories)
//AutoConfigureMockMvc + MockMvcAutoConfiguration + MockMvcSecurityAutoConfiguration + MockMvcWebClientAutoConfiguration + MockMvcWebDriverAutoConfiguration

//@TestPropertySource: read test properties instead of application resource properties

// In this test, the full Spring application context is started (because using of @SpringBootTest) but without the server.
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = {"classpath:application-test.properties"})
class CalculationResource_WebMvcTest_IT {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void testSum() throws Exception {
        SumRequest request = new SumRequest();
        request.setNumberOne("1");
        request.setNumberTwo("10");
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/calculations/sum").contentType("application/json").content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.post("/calculations/sum/").contentType("application/json").content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{'result':'11'}"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/calculations/sum").contentType("application/json").content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        Assertions.assertThat(responseContent).isEqualTo("{\"result\":\"11\"}");
    }

    /*
     *     MockMvc provides an elegant and easy-to-use API to call web endpoints and to inspect and assert their response at the same time.
     *      Despite all its benefits, it has a few limitations.
     *     First of all, it does use a subclass of the DispatcherServlet to handle test requests.
     *      To be more specific, the TestDispatcherServlet is responsible for calling controllers and performing all the familiar Spring magic.
     *     The MockMvc class wraps this TestDispatcherServlet internally.
     *      So every time we send a request using the perform() method, MockMvc will use the underlying TestDispatcherServlet directly.
     *      Therefore, there are no real network connections made, and consequently, we won't test the whole network stack while using MockMvc.
     *     Also, because Spring prepares a fake web application context to mock the HTTP requests and responses,
     *      it may not support all the features of a full-blown Spring application.
     *     For example, this mock setup doesn't support HTTP redirections. This may not seem that significant at first.
     *      However, Spring Boot handles some errors by redirecting the current request to the /error endpoint. So if we're using the MockMvc,
     *      we may not be able to test some API failures.
     *     As an alternative to MockMvc, we can set up a more real application context and then use RestTemplate,
     *     or even REST-assured, to test our application.
     */
}