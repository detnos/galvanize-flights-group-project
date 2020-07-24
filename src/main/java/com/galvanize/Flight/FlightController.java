package com.galvanize.Flight;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class FlightController {

    private final FlightRepository repository;

    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Flight> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Flight create(@RequestBody Flight flight) {
        return this.repository.save(flight);
    }
}
