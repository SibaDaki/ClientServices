package ShuttleSystemBackend.factory;

import ShuttleSystemBackend.domain.TripDetails;

/**
 * Created by User on 2017/09/07.
 */
public class TripFactory {

    public static TripDetails createTrip(String departure, String time, String destination) {
        return new TripDetails.TripBuilder()
                .departure(departure)
                .time(time)
                .destination(destination)
                .build();
    }
}
