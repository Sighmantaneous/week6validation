package ie.atu.gitactionsweek5.passenger.controller;


import ie.atu.gitactionsweek5.passenger.model.Passenger;
import ie.atu.gitactionsweek5.passenger.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping
public class PassengerController{

    private final PassengerService service;
    public PassengerController(PassengerService service) {this.service = service;}

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getOne(@PathVariable String id) {
        Optional<Passenger> maybe = service.findById(id);

        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        }
        else  {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<Passenger> create(@RequestBody Passenger p) {
        Passenger created = service.create(p);
        return ResponseEntity
                .created(URI.create("/api/passengers/" + created.getPassengerId()))
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> update(@RequestBody Passenger p) {
        Optional<Passenger> maybe = service.update(p);
        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        }
        else  {
            return ResponseEntity.notFound().build();
        }


    }




}
