package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.BusDetails;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 2017/09/07.
 */
public class BustDetailTest {

    private BusDetails busDetails;

    @Test
    public void testCreate() throws Exception {
        busDetails = BusDetailsFactory.createBus("CA123",20);
        Assert.assertNotNull(busDetails);
    }

    @Test
    public void testUpdate() throws Exception {
        busDetails = BusDetailsFactory.createBus("CA123",20);
        BusDetails copyBusDetails = new BusDetails.BusBuilder()
                .copy(busDetails)
                .getnumberPlate("CA321")
                .build();
        Assert.assertEquals(copyBusDetails.getNumberPlate(),"CA321");

    }
}
