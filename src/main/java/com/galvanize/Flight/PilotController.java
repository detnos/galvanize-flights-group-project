package com.galvanize.Flight;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/pilots")
public class PilotController {
    private final PilotRepository repository;

    public PilotController(PilotRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Pilot> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Pilot create(@RequestBody Pilot pilot) {
        return this.repository.save(pilot);
    }

    @PatchMapping("/{id}")
    public Pilot patch(@PathVariable Long id, @RequestBody Pilot pilot) {
        Pilot originalPilot = this.repository.findById(id).get();

        if (!pilot.getFirstName().equals(originalPilot.getFirstName())) {
            originalPilot.setFirstName(pilot.getFirstName());
        }
        if (!pilot.getLastName().equals(originalPilot.getLastName())) {
            originalPilot.setLastName(pilot.getLastName());
        }

        return this.repository.save(originalPilot);
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
