package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.Passenger;

/**
 * Created by User on 2017/09/07.
 */
public class PassengerFactory {

    public static Passenger createPassenger(String name, String lastName){
        return new Passenger.PassengerBuilder()
                .name(name)
                .lastName(lastName)
                .build();
    }
}
