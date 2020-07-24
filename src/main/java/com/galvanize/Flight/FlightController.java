package com.galvanize.Flight;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
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

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {

        try {
            this.repository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
