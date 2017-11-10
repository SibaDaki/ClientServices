package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.TripDetails;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by User on 2017/09/07.
 */
public class TripDetailsTests {

    private TripDetails tripDetails;

    @Test
    public void testCreate() throws Exception {
        tripDetails = TripFactory.createTrip("CPT","12hrs","JHB");

        Assert.assertEquals(tripDetails.getDestination(),"JHB");
        Assert.assertEquals(tripDetails.getDeparture(),"CPT");
        Assert.assertEquals(tripDetails.getTime(),"12hrs");
    }

    @Test
    public void testUpdate() throws Exception {
        tripDetails = TripFactory.createTrip("CPT","12hrs","JHB");

        TripDetails copyTripDetails = new TripDetails.TripBuilder()
                .copy(tripDetails)
                .time("10hrs")
                .build();
        Assert.assertEquals(copyTripDetails.getDeparture(),"CPT");
        Assert.assertEquals(copyTripDetails.getTime(),"10hrs");

    }
}
