package com.example.new_json_playground;

import com.example.new_json_playground.JSONResponseController;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.JsonPathExpectationsHelper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import javax.servlet.http.Cookie;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringFlightControllerTest {

    @Autowired
    MockMvc mvc;

    @Nested
    class springFlightTests{

    @Test
    public void endPoint1TestFromStringLiteral() throws Exception {
        //String json = getJSON("/data/flights.json");

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"tickets\": [\n" +
                        "    {\n" +
                        "      \"passenger\": {\n" +
                        "        \"firstName\": \"Some name\",\n" +
                        "        \"lastName\": \"Some other name\"\n" +
                        "      },\n" +
                        "      \"price\": 200\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"passenger\": {\n" +
                        "        \"firstName\": \"Name B\",\n" +
                        "        \"lastName\": \"Name C\"\n" +
                        "      },\n" +
                        "      \"price\": 150\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}");

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"result\":350}"));
        }
        @Test
        public void endPoint1TestFromObjectMapper() throws Exception{


            Flight flight = new Flight();

            //flight.setDeparts("2017-04-21 14:34");
            List<Flight.Ticket> ticketList = new ArrayList<>();

            Flight.Person passenger1 = new Flight.Person();
            passenger1.setFirstName("Carlos");
            passenger1.setLastName("Padilla");

            Flight.Ticket ticket1 = new Flight.Ticket();
            ticket1.setPassenger(passenger1);
            ticket1.setPrice(200);

            ticketList.add(ticket1);

            Flight.Person passenger2 = new Flight.Person();
            passenger1.setFirstName("Jose");
            passenger1.setLastName("Morales");

            Flight.Ticket ticket2 = new Flight.Ticket();
            ticket2.setPassenger(passenger1);
            ticket2.setPrice(150);

            ticketList.add(ticket2);

            flight.setTickets(ticketList);

            //HashMap<String, Flight.Ticket> tickets = new HashMap<>();

            ObjectMapper objectMapper = new ObjectMapper();

            String jsonstring = objectMapper.writeValueAsString(flight);

            mvc.perform(post("/flights/tickets/total")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonstring))

                    .andExpect(status().isOk())
                    .andExpect(content().string("{\"result\":350}"));

        }

        @Test
        public void endPoint1JsonFromFile() throws Exception {
            String json = getJSON("/data/flights.json");

            mvc.perform(post("/flights/tickets/total")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(json))

                    .andExpect(status().isOk())
                    .andExpect(content().string("{\"result\":350}"));





        }
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
