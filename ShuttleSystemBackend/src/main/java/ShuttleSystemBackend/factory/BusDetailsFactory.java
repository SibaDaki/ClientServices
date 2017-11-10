package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.BusDetails;

/**
 * Created by User on 2017/09/07.
 */
public class BusDetailsFactory {

    public static BusDetails createBus(String numPlate, int seatsNum){
        return new BusDetails.BusBuilder()
                .getnumberPlate(numPlate)
                .seats(seatsNum)
                .build();
    }
}
