package com.example.new_json_playground;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SpringFlightController {

    @PostMapping("/flights/tickets/total")
    public Map<String, Integer> getJSONData (@RequestBody Flight flight) {

        int totalTicketCost = 0;
        for (int i = 0; i < flight.getTickets().size(); i++) {
            totalTicketCost += flight.getTickets().get(i).getPrice();
        }
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("result", totalTicketCost);


        return myMap;
    }

}
