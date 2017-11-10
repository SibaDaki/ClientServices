package ShuttleSystemBackend.repository;

import ShuttleSystemBackend.domain.Passenger;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by User on 2017/09/07.
 */
public interface PassengerRepository extends CrudRepository<Passenger,Long> {
}
