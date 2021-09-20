package com.example.new_json_playground;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class JSONResponseController {

    @GetMapping("/flights/flight")
    public Flight getFlightInfo() throws ParseException {

        Flight flight = new Flight();

        flight.setDeparts("2017-04-21 14:34");
        List<Flight.Ticket> ticketList = new ArrayList<>();

        Flight.Person passenger1 = new Flight.Person();
        passenger1.setFirstName("Jose");
        //passenger1.setLastName("Padilla");

        Flight.Ticket ticket1 = new Flight.Ticket();
        ticket1.setPassenger(passenger1);
        ticket1.setPrice(200);

        ticketList.add(ticket1);

        flight.setTickets(ticketList);

        return flight;
    }
    @GetMapping("/flights")
    public List<Flight> getFlights() throws ParseException {
        List<Flight> flightList = new ArrayList<>();
        //flight 1
        Flight flight = new Flight();
        flight.setFlightNumber("UA234");

        flight.setDeparts("2017-04-21 14:34");
        List<Flight.Ticket> ticketList1 = new ArrayList<>();

        Flight.Person passenger1 = new Flight.Person();
        passenger1.setFirstName("Jose");
        passenger1.setLastName("Padilla");

        Flight.Ticket ticket1 = new Flight.Ticket();
        ticket1.setPassenger(passenger1);
        ticket1.setPrice(200);

        ticketList1.add(ticket1);

        flight.setTickets(ticketList1);

        //flight 2
        Flight flight2 = new Flight();
        flight2.setFlightNumber("DL2101");

        flight2.setDeparts("2017-04-24 14:00");
        List<Flight.Ticket> ticketList2 = new ArrayList<>();

        Flight.Person passenger2 = new Flight.Person();
        passenger2.setFirstName("Carlos");
        //passenger2.setLastName("Molinares");

        Flight.Ticket ticket2 = new Flight.Ticket();
        ticket2.setPassenger(passenger2);
        ticket2.setPrice(300);

        ticketList2.add(ticket2);

        flight2.setTickets(ticketList2);

        //add both flights to the flightlist
        flightList.add(flight);
        flightList.add(flight2);

        return flightList;
    }
}