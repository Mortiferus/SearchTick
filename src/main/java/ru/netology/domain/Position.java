package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Position implements Comparable<Position> {
    int id;
    int price;
    String departureAirport;
    String arrivalAirport;
    int flightTime;

    public boolean matches(String from, String to) {
        return (this.departureAirport().equalsIgnoreCase(from)) && (this.arrivalAirport().equalsIgnoreCase(to));
    }

    @Override
    public int compareTo(Position o) {
        return price - o.price;
    }
}