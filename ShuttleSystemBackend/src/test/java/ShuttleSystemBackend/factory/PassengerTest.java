package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.Passenger;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 2017/09/07.
 */
public class PassengerTest {

    private Passenger passenger;
   // private TravelerAddress travelerAddress;

    @Test
    public void testCreate() throws Exception {
      //  travelerAddress = AddressFactory.createPassangerAddress("streetTest","CityTest","1000");
        passenger = PassengerFactory.createPassenger("admin","testlastname");

       // Assert.assertEquals(passenger.getObjAdress().getStreet(),"streetTest");
        Assert.assertEquals(passenger.getFirstName(),"admin");

    }

    @Test
    public void testUpdate() throws Exception {
        //travelerAddress = AddressFactory.createPassangerAddress("streetTest","CityTest","1000");
        passenger = PassengerFactory.createPassenger("admin","testlastname");

        Passenger copyTraveler = new Passenger.PassengerBuilder()
                .copy(passenger)
                .name("testName")
                .build();
        Assert.assertEquals(copyTraveler.getFirstName(),"testName");

    }

}
