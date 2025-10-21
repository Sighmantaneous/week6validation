package ie.atu.gitactionsweek5.passenger.service;

import ie.atu.gitactionsweek5.passenger.model.Passenger;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerServiceTest {

    private PassengerService service;

    @BeforeEach
     void setUp() {service = new PassengerService();}

    @Test
    void createThenFindById(){
        Passenger p = Passenger.builder()
                .passengerId("P1")
                .name("Simon")
                .email("Si@atu.ie")
                .build();
        service.create(p);

        Optional<Passenger> found = service.findById("P1");
        assertTrue(found.isPresent());
        assertEquals("Simon", found.get().getName());
    }

    @Test
    void updatePassenger() {
        Passenger p = new Passenger("7", "simon", "simon@atu");

        service.create(p);

        Passenger updated = new Passenger("7", "sighman", "sighman@atu");
        service.update(updated);
        Optional<Passenger> found = service.update(updated);
        assertTrue(found.isPresent());
        assertEquals("sighman", found.get().getName());
        assertEquals("sighman@atu", found.get().getEmail());

        }

    @Test
    void deletePassengerId() {
        Passenger p = new Passenger("7", "simon", "simon@atu");

        service.create(p);

        Optional<Passenger> deletePassenger = service.deleteById("7");

        assertTrue(deletePassenger.isPresent());

        assertEquals("simon", deletePassenger.get().getName());
        assertEquals("simon@atu", deletePassenger.get().getEmail());
 }


}


