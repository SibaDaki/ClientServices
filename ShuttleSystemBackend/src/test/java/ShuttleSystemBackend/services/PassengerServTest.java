package ShuttleSystemBackend.services;

import ShuttleSystemBackend.domain.Passenger;
import ShuttleSystemBackend.factory.PassengerFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by User on 2017/09/07.
 */
public class PassengerServTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private  PassangerService service;

    @Test
    public void testCreate() throws Exception {

        Passenger passenger = PassengerFactory.createPassenger("admin","test");
        Passenger savedTraveler =service.create(passenger);

        assertNotNull("CREATE TEST", savedTraveler);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testReadAll() throws Exception {
        Iterable<Passenger> passengers =  service.readAll();

        assertNotNull("READ TEST",passengers);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdate() throws Exception {
        Passenger passengerFound = service.readById(1L);
        Passenger updatePassenger = new Passenger.PassengerBuilder()
                .copy(passengerFound)
                .name("service testupdate")
                .build();
        Passenger updatedPassenger =service.update(updatePassenger);
        Assert.assertSame("UPDATE TEST", updatePassenger.getFirstName(), updatedPassenger.getFirstName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Passenger foundPassemger = service.readById(3L);
        if(foundPassemger !=null) {
            assertNotNull("BEFORE DELETE TEST",foundPassemger);
            service.delete(foundPassemger);
            Passenger deletedpassenger = service.readById(3L);

            assertNull("DELETE TEST",deletedpassenger);
        }

    }
}

