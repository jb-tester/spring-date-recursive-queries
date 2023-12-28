package com.mytests.spring.springdaterecursivequeries.recursiveQueries;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "flights")
public class Flights {
    @Id
    private Long id;

    String departure;
    String arrival;
    String carrier;
    String flight_num;
    int ticket;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getFlight_num() {
        return flight_num;
    }

    public void setFlight_num(String flight_num) {
        this.flight_num = flight_num;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public Flights(Long id, String departure, String arrival, String carrier, String flight_num, int ticket) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.carrier = carrier;
        this.flight_num = flight_num;
        this.ticket = ticket;
    }

    public Flights() {
    }

    @Override
    public String toString() {
        return "Flights{" +
               "id=" + id +
               ", departure='" + departure + '\'' +
               ", arrival='" + arrival + '\'' +
               ", carrier='" + carrier + '\'' +
               ", flight_num='" + flight_num + '\'' +
               ", ticket=" + ticket +
               '}';
    }
}
