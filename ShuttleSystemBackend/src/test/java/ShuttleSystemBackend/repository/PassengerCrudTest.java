package ShuttleSystemBackend.repository;

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
public class PassengerCrudTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private  PassengerRepository repository;

    @org.testng.annotations.Test
    public void testCreate() throws Exception {
        //repository.deleteAll();
        //TravelerAddress employeeAddress = AddressFactory.createPassangerAddress("admin","test","0000");
        Passenger passenger = PassengerFactory.createPassenger("admin","test");
        Passenger savedTraveler =repository.save(passenger);

        assertNotNull("CREATE TEST", savedTraveler);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testReadAll() throws Exception {
        Iterable<Passenger> passengers =  repository.findAll();

        assertNotNull("READ TEST",passengers);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdate() throws Exception {
        Passenger passengerFound = repository.findOne(1L);
        Passenger updatePassenger = new Passenger.PassengerBuilder()
                .copy(passengerFound)
                .name("testupdate")
                .build();
        Passenger updatedPassenger =repository.save(updatePassenger);
        Assert.assertSame("UPDATE TEST", updatePassenger.getFirstName(), updatedPassenger.getFirstName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Passenger foundPassenger = repository.findOne(2L);
        if(foundPassenger !=null) {
            assertNotNull("BEFORE DELETE TEST",foundPassenger);
            repository.delete(2L);
            Passenger deletedpassenger = repository.findOne(2L);

            assertNull("DELETE TEST",deletedpassenger);
        }

    }
}