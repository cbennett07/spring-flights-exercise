package com.example.new_json_playground;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.spi.TimeZoneNameProvider;

public class Flight {
    //private Date departs;
    private List<Ticket> tickets;
    //private String flightNumber;

//    public String getFlightNumber() {
//        return flightNumber;
//    }
//
//    public void setFlightNumber(String flightNumber) {
//        this.flightNumber = flightNumber;
//    }
//    public Date getDeparts() {
//        return departs;
//    }
//
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "America/Chicago")
//    public void setDeparts(String departs) throws ParseException {
//        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        this.departs = sdf.parse(departs);
//
//    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    static class Ticket {
        private Person passenger;
        private int price;


        public Person getPassenger() {
            return passenger;
        }

        public void setPassenger(Person passenger) {
            this.passenger = passenger;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

    }

    static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
