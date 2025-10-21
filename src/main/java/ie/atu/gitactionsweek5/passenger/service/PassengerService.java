package ie.atu.gitactionsweek5.passenger.service;


import ie.atu.gitactionsweek5.passenger.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Passenger> findById(String id) {
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p) {
        if (findById(p.getPassengerId()).isPresent()) {
            throw new IllegalStateException("Passenger with id " + p.getPassengerId() + " already exists");
        }
        store.add(p);
        return p;
    }
    public Optional<Passenger> update(Passenger p) {
        Optional<Passenger> maybe = findById(p.getPassengerId());
        if(maybe.isPresent()) {
            Passenger update = maybe.get();
            update.setName(p.getName());
            update.setEmail(p.getEmail());
            return Optional.of(update);
        } else {
            return Optional.empty();
        }
    }
    public Optional<Passenger> deleteById(String id){
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                store.remove(p);
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

}
