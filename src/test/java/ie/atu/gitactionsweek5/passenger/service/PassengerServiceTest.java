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

}
