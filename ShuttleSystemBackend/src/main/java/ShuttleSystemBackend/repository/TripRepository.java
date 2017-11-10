package ShuttleSystemBackend.repository;

import ShuttleSystemBackend.domain.TripDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by User on 2017/09/07.
 */
public interface TripRepository extends CrudRepository<TripDetails,Long> {
}
